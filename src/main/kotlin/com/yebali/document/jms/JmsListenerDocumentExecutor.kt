package com.yebali.document.jms

import com.yebali.document.jms.confluence.ConfluenceDocumentExecutor
import org.reflections8.Reflections
import org.reflections8.scanners.MethodAnnotationsScanner
import org.springframework.jms.annotation.JmsListener

class JmsListenerDocumentExecutor {
    companion object {
        fun <T> execute(clazz: Class<T>) {
            val activeLevel = System.getProperty("spring.profiles.active")
            val jmsListenerDocument = getJmsListenerDocumentAnnotation(clazz)

            if (activeLevel != jmsListenerDocument.activeLevel)
                return

            val jmsListenerInfo = getJmsListenerInfo(jmsListenerDocument)

            val executor = ConfluenceDocumentExecutor(
                jmsListenerDocument.confluenceContentId,
                jmsListenerInfo
            )

            executor.document()
        }

        private fun <T> getJmsListenerDocumentAnnotation(clazz: Class<T>): JmsListenerDocument {
            if (clazz.isAnnotationPresent(JmsListenerDocument::class.java)) {
                return clazz.getAnnotation(JmsListenerDocument::class.java)
            } else {
                throw Exception()
            }
        }

        private fun getJmsListenerInfo(jmsListenerDocumentInfo: JmsListenerDocument): List<JmsListenerData> {
            val reflections = Reflections(jmsListenerDocumentInfo.rootScanPath, MethodAnnotationsScanner())
            val methods = reflections.getMethodsAnnotatedWith(JmsListener::class.java)
            val serviceName = System.getenv()["SERVICE_NAME"] ?: "Could Not figure out service name.."

            val jmsListenerData = methods.map { it ->
                val annotation = it.getAnnotation(JmsListener::class.java)

                try {
                    var morphemes = annotation.destination.split(".")
                    var paramTypes = it.parameterTypes.map { it.name ?: "" }

                    JmsListenerData(
                        serviceName = serviceName,
                        methodName = it.name,
                        paramTypes = paramTypes,
                        subscribingEventName = morphemes.last(),
                    )
                } catch (e: Exception) {
                    JmsListenerData(
                        serviceName = "jmsListener destination = ${annotation.destination}",
                        methodName = "",
                        paramTypes = listOf(),
                        subscribingEventName = ""
                    )
                }
            }

            return jmsListenerData.sortedBy { it.subscribingEventName }
        }
    }
}
