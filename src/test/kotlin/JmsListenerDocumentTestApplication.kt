import com.yebali.document.jms.JmsListenerDocument
import com.yebali.document.jms.JmsListenerDocumentExecutor

@JmsListenerDocument(
    rootScanPath = "com.yebali.mid",
    confluenceContentId = "308412445",
    activeLevel = "dev"
)
class JmsListenerDocumentTestApplication

fun main(args: Array<String>) {
    JmsListenerDocumentExecutor.execute(JmsListenerDocumentTestApplication::class.java)
}
