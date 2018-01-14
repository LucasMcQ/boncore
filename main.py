import time
from pyb import UART

uart = UART(6, 9600)
uart.init(9600, bits=8, parity=None, stop=1)

filename = "gpsData.txt"
file = open(filename, "w")

#for i in range(5):
line = uart.readline()
file.write(line)    

file.close()
