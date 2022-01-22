package com.yebali.document.jms

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class JmsListenerDocument(
    /**
     * Scanning start point.
     */
    val rootScanPath: String,

    /**
     * ContentId of Confluence.
     */
    val confluenceContentId: String,

    /**
     *Active level to be documented
     */
    val activeLevel: String,
)
