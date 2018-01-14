newfile = open("parsedData.txt", "w")

key = "GPGGA"

with open("gpsData.txt") as f:
        content = f.readlines()
for x in content:
        if key in x:
                newfile.write(x)
                newfile.flush()
newfile.close()
