cat /usr/share/applications/dia.desktop > alldesktop.tmp

echo > newdesktop.txt

while read -r linha
do
	if echo $linha |egrep 'Name='
	then

		echo $linha >> newdesktop.txt
	fi

	if echo $linha |egrep 'Comment='
	then

		echo $linha >> newdesktop.txt
	fi

	if echo $linha |egrep 'Exec='
	then

		echo $linha >> newdesktop.txt
	fi

	if echo $linha |egrep 'Version='
	then

		echo $linha >> newdesktop.txt
	fi

	if echo $linha |egrep 'Categories='
	then

		echo $linha >> newdesktop.txt
	fi

	if echo $linha |egrep 'Icon='
	then

		echo $linha >> newdesktop.txt
	fi



done < alldesktop.tmp  #redirecionamento de entrada
