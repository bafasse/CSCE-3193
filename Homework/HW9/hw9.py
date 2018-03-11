import function

word = input("Enter a keyword to transform the alphabet: ")
while (word == ""):
	word = input("Enter a keyword to transform the alphabet: ")

print("Keyword: ", word)
word = word.upper()
orig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
orig = " ".join(orig)

transAlpha = function.TRANSFORMEDALPHABET(word)
print("\n")
print(orig)
print(transAlpha)

choice = input("\nPress [1] to read from a pre-made file, otheriwse press [2]: ")
if(choice == "1"):
        fileName = input("Enter the name of the file: ")
        fileObject = open(fileName, "r")
        fileList = ""

        for line in fileObject:
                line = line.strip()
                line = line.upper()
                fileList = fileList + line

        message = fileList
		
elif (choice == "2"):
	message = input("Enter message to be encrypted: ")
	while (message == ""):
		message = input("Enter message to be encrypted: ")

message = message.upper()
print("\nmessage: ", message)

numberList = []

for i, c in enumerate(message):
	for j, d in enumerate(orig):
		if (c == d):
			numberList.append(j)
			if (c == " "):
				numberList.append(c)
			else:
				pass

code = ""
for x in numberList:
	for i, c in enumerate(transAlpha):
		if (i == x):
			code = code + c
			
prev = ' '
for letter in code:
	if(letter == prev):
		code = code.replace(" ", "")
	code = code.strip()
	
print ("\nencrypted message: ", code)							
	
