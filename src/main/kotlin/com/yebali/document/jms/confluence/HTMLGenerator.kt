package com.yebali.document.jms.confluence

class HTMLGenerator {
    var context = ""

    fun putH1(value: String) {
        context += "<h1>$value</h1>"
    }

    fun putH2(value: String) {
        context += "<h2>$value</h2>"
    }

    fun putH3(value: String) {
        context += "<h3>$value</h3>"
    }

    fun putH4(value: String) {
        context += "<h4>$value</h4>"
    }

    fun putLi(value: String) {
        context += "<li>$value</li>"
    }

    fun putP(value: String) {
        context += "<p>$value</p>"
    }

    fun putNewLine() {
        context += "<p>&nbsp;</p>"
    }

    fun putHr() {
        context += "<hr/>"
    }
}
