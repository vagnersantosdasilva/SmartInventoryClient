#ler arquivo de entrada linha a linha

echo > passo4.txt
contador=0
while read -r linha
do
	contador=$((contador+1))
	if [ "$contador" -eq 2 ]; then
		echo "\tModel:$linha" >> passo4.txt

	fi

	if [ "$contador" -eq 3 ]; then
		echo "\tManufacturer:$linha" >> passo4.txt

	fi
	if [ "$contador" -eq 4 ]; then
		echo "\tRemovible:$linha" >> passo4.txt

	fi
	if [ "$contador" -eq 5 ]; then
		echo "\tSectors:$linha" >> passo4.txt

	fi
	if [ "$contador" -eq 6 ]; then
		echo "\tSize:$linha" >> passo4.txt
		

	fi
	if [ "$contador" -eq 7 ]; then
		echo "\tlogicalUnit:$linha\n" >> passo4.txt
		contador=1

	fi
 
done < passo3.txt  #redirecionamento de entrada
cat passo4.txt
rm passo3.txt
rm passo4.txt