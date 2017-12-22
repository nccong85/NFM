<%@ page import="vn.com.nsmv.entities.SMstUserEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/resources/css/import.css"/>" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.metisMenu.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.ja.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.contextMenu.js"/>"></script>
<script src="<c:url value="/resources/js/global-properties.js"/>"></script>
<script src="<c:url value="/resources/js/common.js"/>"></script>
<script src="<c:url value="/resources/js/common-ajax.js"/>"></script>
<script src="<c:url value="/resources/js/common-plugin.js"/>"></script>
<script src="<c:url value="/resources/js/custom.js"/>"></script>

<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
       <div class="navbar-header">
           <a class="navbar-brand" href="<c:url value= "/NFMYGX0020/"/>">NF&amp;M輸送費計算システム</a> 
       </div>
		<%
		SMstUserEntity user = (SMstUserEntity) session.getAttribute("user");
		StringBuffer userInfo = new StringBuffer();
		
		if(user!=null){
			userInfo.append(user.getUserKaishaName());
			userInfo.append("."+user.getUserShozoku());
			userInfo.append("."+user.getUserName());
		}
		%>
	<div style="color: white;padding: 10px 60px 5px 60px;float: right;font-size: 15px;"><%=userInfo%>
		<a href="<c:url value="/NFMYGX0010/logout"/>" class="btn btn-default logoutButton">ログアウト</a>
		
		
	</div>
</nav>
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                	  <li>
                        <a href="#" class="active-menu"><i class="fa fa-jpy" aria-hidden="true"></i>輸送費管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<c:url value= "/NFMYGX0100/init"/>">輸送費検索</a>
                            </li>
                            <li>
                                <a href="<c:url value= "/NFMYGX0120/"/>">輸送費新規登録</a>
                            </li>
                        </ul>
                      </li>  
                    <li>
                        <a  href="<c:url value="/NFMYGX0200/init"/>"><i class="fa fa-clock-o" aria-hidden="true"></i>随時処理</a>
                    </li>
                     <li>
                        <a  href="<c:url value="/NFMYGX0300/"/>"><i class="fa fa-calendar" aria-hidden="true"></i>月次処理 </a>
                    </li>
                    <li>
                        <a  href="<c:url value="/NFMYGX0180/"/>"><i class="fa fa-file-o" aria-hidden="true"></i>ファイル取込</a>
                    </li>
					<li  >
						<a href="#"><i class="fa fa-user" aria-hidden="true"></i>ユーザ管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<c:url value="/NFMYGX0400/"/>">ユーザ検索</a>
                            </li>
                            <li>
                                <a href="#">パスワード変更</a>
                            </li>
                        </ul>
                    </li>	
                </ul>               
            </div>
            
        </nav>