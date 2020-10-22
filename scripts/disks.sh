echo > passo0.txt
echo > passo1.txt
echo > passo2.sh
echo > passo3.txt
echo > passo4.txt


fdisk -l |grep ' /dev/sd' |awk -F "/dev/" '{if ($2!="") print $2 " >> passo3.txt"}'| awk -F ":" '{print $1 " : echo " $2}' >> passo0.txt

ls /sys/block|grep sd|awk  '{print $1 ": echo " $1 " >> passo3.txt" }' >> passo0.txt
ls /sys/block|grep sd|awk  '{print $1 ": cat /sys/block/" $1 "/removable >>passo3.txt"}' >> passo0.txt
ls /sys/block|grep sd|awk  '{print $1 ": cat /sys/block/" $1 "/device/vendor >>passo3.txt #"}' >> passo0.txt
ls /sys/block|grep sd|awk  '{print $1 ": cat /sys/block/" $1 "/device/model >>passo3.txt"}' >> passo0.txt
ls /sys/block|grep sd|awk  '{print $1 ": cat /sys/block/" $1 "/size >>passo3.txt"}' >> passo0.txt

sort passo0.txt > passo1.txt
cat passo1.txt |awk -F ":" '{print $2}' >> passo2.sh
sh passo2.sh
rm passo0.txt
rm passo1.txt
rm passo2.sh
#sh transformer.sh

#cat passo4.txt
#passo3.txt
#passo4.txt