<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<title>≤‚ ‘FCKeditor</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var oFCKeditor = new FCKeditor('content');
		oFCKeditor.BasePath = "fckeditor/";
		oFCKeditor.ReplaceTextarea();
	}
</script>
</head>

<body>
	<textarea rows="10" cols="40" name="content"></textarea>
</body>
</html>