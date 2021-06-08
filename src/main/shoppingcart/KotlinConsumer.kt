package main.shoppingcart


import org.junit.platform.commons.logging.LoggerFactory

@Component
class KotlinConsumer {
    private val logger = LoggerFactory.getLogger(javaClass)
    @KafkaListener(topics = ["transaction-notification"], groupId = "simple-kotlin-consumer")
    fun processMessage(message: String) {
        logger.info("got message: {}", message)
    }
}
