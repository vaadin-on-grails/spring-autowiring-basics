grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.fork = [
        test   : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon: true],
        run    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        war    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    inherits("global") {
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        compile 'javax.validation:validation-api:1.1.0.Final'

        test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
    }

    plugins {
        build ":tomcat:7.0.55"

        compile ':vaadin:7.3.6'

        runtime ":hibernate4:4.3.6.1" // or ":hibernate:3.6.10.18"
        runtime ":database-migration:1.4.0"
    }
}
