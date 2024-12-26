curl https://yesno.wtf/api?ref=public_apis

https:
    tshark -i wlp1s0 -f "host yesno.wtf" -w yesno.wtf.pcap
    tshark -r yesno.wtf.stealth.pcap -T fields -E separator=, -E quote=d -e frame.time -e ip.src -e ip.dst -e _ws.col.Info
stealth:
