import random

tf = open("inputs.txt", "w")

for i in range(0, 100000):
	tf.write( str(random.randint(1, 9999999))+"\n" )

tf.close()
