import time
import pyb
from pyb import UART

uart = UART(6, 9600)
uart.init(9600, bits=8, parity=None, stop=1)

filename = "gpsData.txt"
uart.write("$PMTK314,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0*2C\r\n")

i = 0
while i < 30:
    if uart.any() > 0:
        file = open(filename, "a")
        line = uart.readline()
        line = line.decode("utf-8") #ser.readline returns a binary, convert to string
        file.write(line)
        file.flush()
        i = i + 1
        file.close()

pyb.LED(1).on()
pyb.LED(2).on()
pyb.LED(3).on()
pyb.LED(4).on()
