package main

import io.socket.client.IO
import io.socket.emitter.Emitter

object SockrtIO extends App {
  var socket = IO.socket("http://localhost:1997")
  println("Connected")
  val printListener: Emitter.Listener = new Emitter.Listener {
    override def call(args: AnyRef*): Unit = {
      println( "Time: "+((System.nanoTime - 10000) / 1000000) )
      println(args) //Stop time here for example
    }
  }


  socket.on("info", printListener)
  socket.connect()
  socket.emit("info", "{}")

}
