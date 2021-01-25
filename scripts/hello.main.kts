#!/usr/bin/env kotlin

// example showing how to include a non-standard maven repo
// @file:Repository("https://binrepo.mycompany.com/artifactory/maven-central")

@file:DependsOn("com.github.ajalt:clikt:2.8.0")
@file:DependsOn("ch.qos.logback:logback-core:1.2.3")
@file:DependsOn("ch.qos.logback:logback-classic:1.2.3")
@file:DependsOn("org.slf4j:slf4j-api:1.7.30")
@file:DependsOn("io.github.microutils:kotlin-logging-jvm:2.0.2")

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import mu.KotlinLogging

val log = KotlinLogging.logger {}

class Hello : CliktCommand(
    help = "Sample script showing basic kotlin script usage. Also uses the Clikt library because it's such a useful companion."
) {
    private val count by option(help = "Number of greetings").int().default(1)
    private val name by argument()

    override fun run() {
        for (i in 1..count) {
            log.debug { "Sample log of $name" }
            echo("Hello $name!")
        }
    }
}

Hello().main(args)
