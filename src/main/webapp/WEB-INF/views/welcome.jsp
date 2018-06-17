<!DOCTYPE HTML>
<!-- <html xmlns:th="http://www.thymeleaf.org"> -->
<html>
<head>
<meta charset="utf-8">
<title>Hanon Systems</title>

<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" />

<link
	href="${pageContext.request.contextPath}/css/easy-responsive-tabs.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />

<!--[if IE 7]>         
<link href="/Eng/Content/common.css" rel="stylesheet"> 
<![endif]-->
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="/Scripts/js/modernizr-2.6.2.js"></script>

<![endif]-->
<!-- 모바일 주소표시줄 감추기 -->
<script type="text/javascript">
	if (window.addEventListener) {
		window.addEventListener('load', function() {
			setTimeout(scrollTo, 0, 0, 1);
		}, false);
	}
</script>
<!-- <script src="/js/jquery-1.10.2.min.js"></script> -->
<!--  
<script  type="text/javascript"  th:src="@{js/jquery-1.8.2.min.js}"></script>

<script  type="text/javascript" th:src="@{js/jquery.flexslider.js}"></script>

<script  type="text/javascript" th:src="@{js/jquery.dotdotdot.min.js}"></script>

<script  type="text/javascript" th:src="@{/js/easyResponsiveTabs.js}"></script>

<script   type="text/javascript" th:src="@{/js/jcarousellite_1.0.1.min.js}"></script>

<script   type="text/javascript" th:src="@{/js/ui.js}"></script>

<script  type="text/javascript" th:src="@{/js/otf.js}"></script>


<meta property="og:type" content="website" />
<script  type="text/javascript" th:src="@{/js/common.js}"></script>


-->

<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>

<script
	src="${pageContext.request.contextPath}/js/jquery.dotdotdot.min.js"></script>

<script
	src="${pageContext.request.contextPath}/js/easyResponsiveTabs.js"></script>

<script
	src="${pageContext.request.contextPath}/js/jcarousellite_1.0.1.min.js"></script>

<script src="${pageContext.request.contextPath}/js/ui.js"></script>

<script src="${pageContext.request.contextPath}/js/otf.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<meta property="og:type" content="website" />
<script src="${pageContext.request.contextPath}/js/common.js"></script>



<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-67423294-1', 'auto');
	ga('send', 'pageview');
</script>

</head>
<body>
	<!-- Facebook -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<!-- //Facebook -->
	<!-- Google+ -->
	<script type="text/javascript">
		(function() {
			var po = document.createElement('script');
			po.type = 'text/javascript';
			po.async = true;
			po.src = 'https://apis.google.com/js/plusone.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(po, s);
		})();
	</script>
	<!-- //Google+ -->
	<!-- Twitter -->
	<script>
		!function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
					.test(d.location) ? 'http' : 'https';
			if (!d.getElementById(id)) {
				js = d.createElement(s);
				js.id = id;
				js.src = p + '://platform.twitter.com/widgets.js';
				fjs.parentNode.insertBefore(js, fjs);
			}
		}(document, 'script', 'twitter-wjs');
	</script>
	<!-- //Twitter -->
	<!-- skip navigation -->
	<div id="skip">
		<dl>
			<dt class="blind">direct menu</dt>
			<dd>
				<a href="#nav">go to the menu</a>
			</dd>
			<dd>
				<a href="#main">go to the main contents</a>
			</dd>
		</dl>
	</div>
	<!-- //skip navigation -->
	<div id="wrap">
		<!--careers header-->

		<!--  S : header-->
		<header>
			<h1 class="logo">
				<a href="#">HVCC Logo</a>
			</h1>

			<!-- <div class="util_menu">
			<a href="/En/Main/Careers">Careers</a>
			<a href="http://www.hanonsystems.com/" class="last">Korean</a>
			<a href="/Kr/" class="last">Korean</a>
		</div> -->


			<nav id="nav">
				<ul class="gnb depth1">
					<form method="POST" enctype="multipart/form-data"
						action="/hanon/uploadStocksFile">
						<div class="row">
							<!-- <input
								type="submit" value="Upload Stocks"
								class="btn btn-primary pull-right" /> -->
							<!-- <input type="button" value="Upload Stocks"
								class="btn btn-primary pull-right" />  -->
								<input type="file" id="uploadFile"
								name="file" class="pull-right" />
						</div>
						<!-- <button type="submit"  class="btn btn-primary pull-right">Upload Stocks</button> -->
					</form>
					<!-- 				<li class="m6 "><a href="/En/Suppliers" class="depth1_m current">SUPPLIERS<span class="icon_m_open"></span></a> -->
					<!-- 					<ul class="depth2"> -->
					<!-- 						<li class=""><a href="/En/Suppliers">Supplier Partnership</a></li> -->
					<!-- 					</ul> -->
					<!-- 				</li> -->


				</ul>
			</nav>

		</header>
		<!--  E : header-->

		<!--  S : main-->
		<div id="main">



			<section class="main_banner">
				<article class="main_view">
					<div class="flexslider">
						<ul class="slides">
							<li class="slide01"><a href="#"><img
									src="${pageContext.request.contextPath}/images/main_banner4.jpg"
									alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
									<div class="main_view_txt">
										<h2>
											Automotive Thermal Energy<br />Management Solutions
										</h2>
										<p>
											We have a differentiated solution<br />around system
											integration
										</p>
									</div> </a></li>
							<li class="slide02"><a href="#"><img
									src="${pageContext.request.contextPath}/images/main_banner1.jpg"
									alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
									<div class="main_view_txt">
										<h2>Deep R&D Expertise</h2>
										<p>
											Is one of the critical factors that allows
											<!-- 150721 삭제HVCC-->
											to deliver Innovative climate control solutions to vehicle
											manufactures.
										</p>
									</div> </a></li>
							<li class="slide03"><a href="#"><img
									src="${pageContext.request.contextPath}/images/main_banner3.jpg"
									alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
									<div class="main_view_txt">
										<h2>Eco-Friendly Products</h2>
										<p>
											We seek to deliver eco-friendly solutions <br>that
											benefit customers and communities <br>around the world
										</p>
									</div> </a></li>
							<!-- 20140902 삭제
						<li class="slide03"><a href="/En/Company/Way"><img src="/Eng/Images/main/main_banner2.jpg" alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
						<div class="main_view_txt">
							<h2>One Global Vision for<br>Future Growth</h2>
							<p>People, customers and technology - our core values <br />that underpin the HVCC Way and how we conduct <br />business </p>
						</div>
						</a></li>-->
						</ul>
					</div>
				</article>
			</section>

			<script type="text/javascript">
				$("#uploadFile").on("change", function(e) {
					console.log('on change');
					var formData = new FormData();
					formData.append('file', $('#uploadFile')[0].files[0]);

					$.ajax({
						url : '/hanon/uploadStocksFile',
						type : 'POST',
						data : formData,
						processData : false, // tell jQuery not to process the data
						contentType : false, // tell jQuery not to set contentType
						success : function(data) {
							location. reload(true);
							console.log(data.files[0].newFilename);
							 window.location.href='/hanon/folder/'+data.files[0].newFilename;
						//	alert(data);
						}
					});
				});
			</script>

			<script type="text/javascript"
				src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
			<script type="text/javascript">
				// 쿠키 생성  
				function setCookie(cName, cValue, cDay) {
					var expire = new Date();
					expire.setDate(expire.getDate() + cDay);
					cookies = cName + '=' + escape(cValue) + '; path=/ '; // 한글 깨짐을 막기위해 escape(cValue)를 합니다.
					if (typeof cDay != 'undefined')
						cookies += ';expires=' + expire.toGMTString() + ';';
					document.cookie = cookies;
				}

				// 쿠키 가져오기
				function getCookie(cName) {
					cName = cName + '=';
					var cookieData = document.cookie;
					var start = cookieData.indexOf(cName);
					var cValue = '';
					if (start != -1) {
						start += cName.length;
						var end = cookieData.indexOf(';', start);
						if (end == -1)
							end = cookieData.length;
						cValue = cookieData.substring(start, end);
					}
					return unescape(cValue);
				}

				/*function jsPopup(){
				 if($.browser.msie==true){
				 if($.browser.version <= 7.0){
				 var popup = window.open('/En/Main/PopupTemp','pop','width=400,height=2567')
				 popup.focus();
				 }
				 }
				 }*/

				/* s:20160923 게시
				 function jsPopup(){
				 var popup = window.open('/En/Main/PopupTemp','pop','width=400,height=256, left=0,top=50')
				 popup.focus();
				 }

				 var isShow = getCookie('popuphidden02')=='true'?true:false;
				 if (!isShow){
				 jsPopup();
				 }*/

				/* s:20161011 삭제
				 function jsPopup2(){
				 var popup2 = window.open('/En/Main/PopupTemp02','pop2','width=400,height=256,left=0,top=50')
				 popup2.focus();
				 }

				 var isShow = getCookie('popuphidden')=='true'?true:false;
				 if (!isShow){
				 jsPopup2();
				 }*/
			</script>

		</div>
		<!--  E : main-->

		<!--  S : footer-->
		<footer>
			<div class="copyright">COPYRIGHT&copy;2018 Hanon Systems ALL
				RIGHTS RESERVED.</div>
			<nav>
				<a href="#">Sitemap</a> <a href="#">Privacy Policy</a> <a href="#">Contact
					Us</a> <a href="#" class="last copy_Ethics">Ethics and Integrity</a>
			</nav>
			<!--<div class="sns">
			<a href="#"><img src="/Eng/Images/facebook.png" alt="facebook"></a>
			<a href="#"><img src="/Eng/Images/twitter.png" alt="twitter"></a>
			<a href="#" class="last"><img src="/Eng/Images/google.png" alt="google+"></a>
		</div>-->
			<div class="career_top">
				<a href="#">Careers</a> <a href="#" class="last">TOP ▲</a>
			</div>
		</footer>
		<!--  E : footer-->

	</div>

</body>
</html>