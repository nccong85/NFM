<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>NF&amp;M輸送費計算システム</title>
<link rel="Shortcut icon" href="assets/images/ZP/ZPZZ/ZPZZOL00/icon/favicon.ico" type="image/x-icon" />
<!-- IMPORT CSS-->
<link href="../resources/css/import.css" rel="stylesheet">
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	$( document ).ready(function() {
	  $( "#userId" ).focus();
	});
</script>
</head>

<!-- I'm a Login view -->
<body>
	<div class="container">
		<div class="row">
			<div class="logo col-md-12 col-sm-12 col-xs-12" align="center">
				<h2>NF&amp;M輸送費計算システム</h2>
			</div>
			<div class="clearfix"></div>
			<hr />
			<form:form role="form" action="login" method="post" modelAttribute="NFMYGX0010_UserBean">
				<div style="color: red; height: 50px" align="center">${message}
					<form:errors path="*"/>
				</div>
				<div style="width: 400px; margin: auto;">
					<div class="panel panel-default">
						<div class="panel-heading" align="center"><h3>ログイン</h3></div>
						<div class="panel-body">
							<div class="form-group">
								<form:input tabindex="1" id="userId" path="userId" class="form-control" placeholder="ユーザID" />
							</div>
							<div class="form-group">
								<form:password tabindex="2" path="password" id="password" name="password" class="form-control" placeholder="パスワード"/>
							</div>
							<div>
								<button type="submit" tabindex="3" class="btn btn-primary btn-block loginButton"
									style="font-weight: bold; height: 40px; font-size: 18px;">ログイン</button>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>