<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Facebook share/send Test</title>
	<meta property="fb:app_id" content="655606921292900" />
	<meta property="og:url"           content="http://www.your-domain.com/your-page.html" />
	<meta property="og:type"          content="website" />
	<meta property="og:title"         content="두부사진공유" />
	<meta property="og:description"   content="Your description" />
	<meta property="og:image"         content="http://70.12.109.101:8089/FacebookTest/img/doboo.png" />
	<meta property="og:image:width" content="1200" />
	<meta property="og:image:height" content="627" />

</head>
<body>
<script>
	// .init()
  window.fbAsyncInit = function() {
    FB.init({
      appId      : 'Insert my appId',
      xfbml      : true,
      version    : 'v2.8'
    });
    FB.AppEvents.logPageView();
  };
  
	// facebook SDK
  (function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.8&appId=655606921292900";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));
</script>

공유하기<br>
<div class="fb-share-button" data-href="http://70.12.109.101:8089/FacebookTest/test.jsp" data-layout="button" data-size="small" data-mobile-iframe="true"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Flocalhost%3A8089%2FFacebookTest%2Ftest.jsp&amp;src=sdkpreparse"></a></div>
<br><br>
보내기<br>
<div class="fb-send" data-href="http://70.12.109.101:8089/FacebookTest/test.jsp"></div>

</body>
</html>