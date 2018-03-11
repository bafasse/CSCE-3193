def TRANSFORMEDALPHABET (word):

	alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"

	realWord = word
	word = word.split()[0]

	word2 = ""
	for i, c in enumerate (realWord):
		for j, d in enumerate(alphabet):
			if (c == d and c != " "):
				alphabet = alphabet.replace(d, "")
				word2 = word2 + d

	transAlpha = word2 + alphabet
	for characters in enumerate (transAlpha):
		transAlpha = transAlpha.replace(" ", "")
	transAlpha = " ".join(transAlpha)

	return(transAlpha)