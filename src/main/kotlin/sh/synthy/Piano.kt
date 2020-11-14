package sh.synthy

import java.sql.Timestamp
import javax.sound.midi.MidiDevice
import javax.sound.midi.MidiMessage
import javax.sound.midi.MidiSystem
import javax.sound.midi.Receiver

object Piano {
    val devices = MidiSystem.getMidiDeviceInfo()

    fun enumerate() = sequence {
        for (i in 0..devices.size-1) yield(Pair(i, devices[i].name))
    }

    fun connect(idx: Int) {
        val device = MidiSystem.getMidiDevice(devices[idx])
        device.transmitter.receiver = MidiReceiver(device.deviceInfo.name)
        device.open()
    }
}

class MidiReceiver(val name: String) : Receiver {
    override fun send(msg: MidiMessage?, timestamp: Long) {
        println("Msg: ${msg?.message} @ $timestamp")
    }

    override fun close() {

    }
}