dependencies {
   this.implementation(this.project(":annotations"))
   this.implementation(this.project(":api"))
   this.implementation("redis.clients:jedis:4.2.0")
   this.implementation("com.rabbitmq:amqp-client:5.14.2")
   implementation("net.kyori:adventure-api:4.14.0")
}