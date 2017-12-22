<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>送状データ照会</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-xs-12">
						<h5>出荷情報</h5>
						<table
							class="table-single table-bordered table-condensed col-md-12">
							<tr>
								<th class="caption col-md-2">送状番号</th>
								<td class="form-inline col-md-4" id='sojoNo'>${detail.basho}-${detail.shubetsu}-${detail.oban}</td>
								<td class="caption col-md-2">出荷日</td>
								<td class="col-md-4">
									<fmt:parseDate value="${detail.date}" var="parsedshukkaDate" pattern="yyyyMMdd" />
									<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}"/>
								</td>
							</tr>
							<tr>
								<td class="caption col-md-2">注文番号</td>
								<td>
								${detail.keiyear}-
			                     ${detail.keikankatsu}-
			                     ${detail.keihinshu}-
			                     ${detail.keishubetsu}-
			                     ${detail.keimonth}-
			                     ${detail.keioban}							
								</td>
								<td class="caption col-md-2">需要家</td>
								<td class="col-md-4">${detail.kanji_01}</td>
							</tr>
							<tr>
								<td class="col-md-2 caption">出庫場所</td>
								<td class="col-md-4">${detail.kanji_02}</td>
								<td class="col-md-2 caption">物管1-4</td>
								<td class="col-md-4">${detail.kanji_03}</td>
							</tr>

							<tr>
								<td class="col-md-2 caption">受渡場所</td>
								<td class="col-md-4">${detail.kanji_04}</td>
								<td class="col-md-2 caption">受渡条件</td>
								<td class="col-md-4">${detail.kanji_05}</td>
							</tr>
						</table>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-12 col-xs-12">
						<h5>輸送情報</h5>
						<table
							class="table-single table-bordered table-condensed col-md-12">
							<tr>
								<th class="caption col-md-2">積港</th>
								<td class="col-md-4">${detail.minato}</td>
								<th class="caption col-md-2">揚港</th>
								<td class="col-md-4">${detail.age_minato}</td>
							</tr>

							<tr>
								<td class="caption col-md-2">重量</td>
								<td class="col-md-4">
									<c:choose>
									    <c:when test="${detail.juryo!=null && detail.juryo!=0}">
									        ${detail.juryo} kg
							            </c:when>
							            <c:otherwise>
							            </c:otherwise>
									</c:choose>								
								</td>
								<th class="caption col-md-2">検量料数</th>
								<td class="col-md-4">${detail.ryosu}</td>
							</tr>
							<tr>
								<th class="caption col-md-2">便コード</th>
								<td class="col-md-4">${detail.bincd}</td>
								<th class="caption col-md-2">倉庫保管日数</th>
								<td class="col-md-4">${detail.sokouhokan}</td>
							</tr>
							<tr>
								<th class="caption col-md-2">業者コード</th>
								<td class="col-md-4">${detail.gyoshacd}</td>
								<th class="caption col-md-2">艀滞船日数</th>
								<td class="col-md-4">${detail.futaisen}</td>
							</tr>
							<tr>
								<th class="caption col-md-2">積合コード</th>
								<td class="col-md-4">${detail.tsumiaicd}</td>
								<th class="caption col-md-2">時間外割増</th>
								<td class="col-md-4">${detail.jikangai}</td>
							</tr>
							<tr>
								<th class="caption col-md-2">空トンコード</th>
								<td class="col-md-4">${detail.kuton}</td>
								<th class="caption col-md-2">休日割増</th>
								<td class="col-md-4">${detail.kyuryo}</td>
							</tr>
							<tr>
								<th class="caption col-md-2">長尺</th>
								<td class="col-md-4">${detail.chojaku}</td>
								<th class="caption col-md-2">留置割増</th>
								<td class="col-md-4">${detail.tomeryo}</td>
							</tr>
							<tr>
								<th class="caption col-md-2">長尺１重量</th>
								<td class="col-md-4">
									<c:choose>
									    <c:when test="${detail.cho1ju!=null && detail.cho1ju!=0}">
									        ${detail.cho1ju} kg
							            </c:when>
							            <c:otherwise>
							            </c:otherwise>
									</c:choose>
								</td>
								<th class="caption col-md-2">浜出し区分</th>
								<td class="col-md-4">${detail.hanbai_kbn}</td>
							</tr>
							<tr>
								<th class="caption col-md-2">長尺２重量</th>
								<td class="col-md-4">
									<c:choose>
									    <c:when test="${detail.cho2ju!=null && detail.cho2ju!=0}">
									        ${detail.cho2ju} kg
							            </c:when>
							            <c:otherwise>
							            </c:otherwise>
									</c:choose>
								</td>
								<th class="caption col-md-2">別途協議</th>
								<td class="col-md-4">
								<fmt:formatNumber type="number" value="${detail.betto}" />
								<%-- <fmt:formatNumber value="${detail.betto}" type="currency" currencySymbol="¥" pattern="¤ #,##0;¤ -#,##0"/>--%>
								</td>
							</tr>
							<tr>
								<th class="caption col-md-2　required">台数</th>
								<td class="col-md-4" colspan="3">${detail.daisu}</td>

							</tr>
						</table>
					</div>
				</div>
				
				<div class="row" id="fukusuBinRow">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<h5 style="display: ${display}">便コード追加</h5>
						<table class="table-single table-bordered table-condensed col-md-12">
							<c:forEach items="${listObject}" var="item" varStatus="itr">
								<tr>
									<th class="caption col-md-2">便コード${item.index}</th>
									<td class="col-md-4">${item.bincd}</td>
									<th class="caption col-md-2">重量${item.index}</th>
									<td class="col-md-4">${item.juryo}</td>
								</tr>
							</c:forEach>							
						 </table>
					</div>
				</div>
				
				<br/>
				<div class="row">
					<div class="col-sm-12 col-xs-12">
						<a class="btn btn-primary teiseiButton" href='<c:url value="/NFMYGX0130/edit/${detail.basho}-${detail.shubetsu}-${detail.oban}"/>'>
							<i class="ic-edit-record"></i>訂正
						</a>
						<a class="btn btn-primary deleteButton" onclick="crunchifyAjax()">
							<i class="ic-delete-record"></i>削除
						</a>
						<a class="btn btn-default backButton" href="<c:url value="/NFMYGX0100/init"/>">戻る</a> 
					</div>
				</div>
			</div>
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	
	<c:url var="fullURL" value="/NFMYGX0110/delete/"/>

	<script>
	   function crunchifyAjax() {
		   $.confirmMsgBox("この送状データを削除します。よろしいですか？", function() {
		   var sojoNo = $("#sojoNo").text();
			var path = '<c:out value="${fullURL}"/>' + sojoNo;
			
	        $.ajax({
	            url : path,
	            success : function(data) {
	                if(data=='0') {
	                	$.infoMsgBox("削除しました。", function() {
	                		location.href = '<c:url value="/NFMYGX0100/init"/>';
	                	});
	                	console.log("SUCCESS: ", data);
	                }else{
	                	$.infoMsgBox("Sorry, delete record unsuccessful (^,^)", function() {
	                		console.log("FAIL: ", data);
	                		return false;
	                	});
	                }
	            },
				error : function(e) {
					console.log("ERROR: ", e);
				},
				done : function(e) {
					console.log("DONE");
				}
	        });

		   });
	    }		
	</script>
</body>