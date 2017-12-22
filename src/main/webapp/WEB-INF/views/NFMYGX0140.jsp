<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NF&amp;M輸送費計算システム</title>
<style type="text/css">
	hr {margin-top:5px !important; margin-bottom:5px !important}
</style>
</head>
<body>
    <div id="wrapper">
       <jsp:include page="/WEB-INF/views/common/header.jsp" />
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		<div id="page-inner">
			<div class="row">
                <div class="col-md-12">
                 <h2>輸送費修正</h2>   
                </div>
            </div>
            <br>
            <div id="error" style="color: red; font-size: 13px; font-weight: bold; margin-bottom: 5px">${error}</div>
			<h5>輸送情報</h5>
	         <div class="row">
	            <div class="col-md-12 col-sm-12 col-xs-12">
                 	<table class="table-single table-bordered table-condensed col-md-12">
                 		   <tr>
		                     <th class="caption col-md-2">送状番号</th>
		                     <td class="form-inline col-md-4">${item.sojoNoBasho}-${item.sojoNoShubetsu}-${item.sojoNoOban}
		                     <input type="hidden" value="${item.seizoshoKbn}" id="seizoshoKbn">
		                     <input type="hidden" value="${item.sojoNoBasho}" id="sojoNoBasho">
		                     <input type="hidden" value="${item.sojoNoShubetsu}" id="sojoNoShubetsu">
		                     <input type="hidden" value="${item.sojoNoOban}" id="sojoNoOban">
		                     <input type="hidden" value="${item.sojoNoRenban}" id="sojoNoRenban">
		                     <input type="hidden" value="${item.headTeiseiKbn}" id="headTeiseiKbn">
		                     <input type="hidden" value="${item.headTeiseiKaisu}" id="headTeiseiKaisu">
		                     <input type="hidden" value="${item.seikyuNengetsu}" id="seikyuNengetsu">
		                     </td>
		                     <td class="caption col-md-2">出荷日</td>
		                     <td class="form-inline col-md-4">
		                     	<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd"/>
									<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}"/>
		                     </td>
		                  </tr>
		                  <tr>
		                     <td class="caption col-md-2" >注文番号</td>
		                     <td class="form-inline col-md-4">
		                     	 ${item.keiyakunoYear}-
			                     ${item.keiyakunoKankatsu}-
			                     ${item.keiyakunoHinshu}-
			                     ${item.keiyakunoTorihiki}-
			                     ${item.keiyakunoMonth}-
			                     ${item.keiyakunoOban}
		                     </td>
		                     
		                     <td class="caption col-md-2">需要家</td>
		                     <td class="col-md-4 form-inline">
		                     	${item.ichijiJuyoka}
		                     	<span class="juyokaName" style="font-size: 14px; margin-left: 5px">[${item.userKanji}]</span>
		                     </td>
		                  </tr>
		                  <tr>
		                     <td class="col-md-2 caption" >出庫場所</td>
		                     <td class="col-md-4 form-inline">
		                     	${item.shukkoBasho}
		                     	<span class="shukkoBashoName" style="font-size: 14px; margin-left: 5px">${item.nikenKaji}</span>
		                     </td>
		                     <td class="col-md-2 caption">物管1-4</td>
		                     <td class="col-md-4 form-inline">
		                     	${item.buppin04}
		                     	<span class="buppinName" style="font-size: 14px; margin-left: 5px">${item.bkn4Kanji}</span>
		                     </td>
		                  </tr>		                  
		                  <tr>
		                     <td class="col-md-2 caption">受渡場所</td>
		                     <td class="col-md-4 form-inline">
		                     	${item.ukBasho}
	                     		<span class="ukewatasiBashoName" style="font-size: 14px; margin-left: 5px">${item.a3kUkBasho}</span>
		                     </td>
		                     <td class="col-md-2 caption">受渡条件</td>
		                     <td class="col-md-4 form-inline">
		                    	${item.ukJoken}
	                     		<span class="ukewatasiJokenName" style="font-size: 14px; margin-left: 5px">${item.jokenKanji}</span>
		                     </td>
		                  </tr>                 	
		                  <tr>
		                     <td class="caption col-md-2 required" >便コード</td>
		                     <td class="col-md-4 form-inline" colspan="3">
		                     	<input type="text" class="form-control input-xsmall required" value = "${item.binCd}" maxlength="3" style="width:120px;" id="binCd"/>
	                     		<span class="binName" style="font-size: 14px; margin-left: 20px"></span>
		                     </td>
		                  </tr>	
		                  <tr>
		                     <td class="caption col-md-2" >積港</td>
		                     <td class="col-md-4 form-inline">
		                     	<input type="text" class="form-control input-xsmall" value = "${item.tsumikomiMinato}" maxlength="4" style="width:120px;" id="tsumikomiMinato"/>
		                     </td>
		                     <td class="caption col-md-2" >揚港</td>
		                     <td class="col-md-4 form-inline">
		                     	<input type="text" class="form-control input-xsmall" value = "${item.ageMinato}" maxlength="4" style="width:120px;" id="ageMinato"/>
		                     	<span></span>
		                     </td>
		                  </tr>
		                  <tr>
		                     <td class="caption col-md-2 required" >台数</td>
		                     <td class="col-md-4 form-inline">
		                     	<input type="text" class="form-control input-xsmall number required" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" value = "${item.daisu}" style="width:60px;" id="daisu"/>
		                     </td>
		                     <td class="caption col-md-2 required" >重量</td>
		                     <td class="col-md-4 form-inline">
		                     	<input type="text" class="form-control input-xsmall number required" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" value = "${item.juryo}" style="width:120px;" id="juryo"/>
		                     	<span style="font-size: 14px;">kg</span>
		                     </td>
		                  </tr>
		                  <tr>
		                     <td class="caption col-md-2" >積合コード</td>
		                     <td class="col-md-4 form-inline">
		                     	<input type="text" class="form-control input-xsmall" value = "${item.tsumiaiCd}" maxlength="2" style="width:120px;" id="tsumiaiCd"/>
		                     </td>
		                     <td class="caption col-md-2" >距離</td>
		                     <td class="col-md-4 form-inline">
		                     	<div>
		                     	<input type="text" class="form-control input-xsmall number" value = "${item.kihonYusoKyori}" style="width:120px;" id="kihonYusoKyori"/>
		                     	<span style="font-size: 14px;">km</span>
		                     	</div>
		                     </td>
		                  </tr>	
		                  <tr>
		                     <td class="caption col-md-2" >金額</td>
		                     <td class="col-md-4" colspan="3"><fmt:formatNumber type="number" value="${item.totalKingaku}" />
		                     	<span style="font-size: 14px;">円</span>
		                     </td>
		                  </tr>	
		               </table>
                 </div>
	         </div>
            <br>	         
	         <h5>費目明細情報</h5>
	         <div class="row">
	         	<table class="col-md-12 col-sm-12 col-xs-12">
					<tr>
					     <td class="col-md-6" >	<button type="button" class="btn btn-default himokuDeleteButton">
					     	<i class="ic-delete-record"></i>削除</button>
					     </td>
					     <td class="col-md-3" align="right">
					         <button type="button" class="btn btn-default himokuAddButton">
					         <i class="ic-add-record"></i>費目追加</button>
						 </td>
					  </tr>
				</table>
		     </div> 
	         <div class="row">
		         <div class="col-md-12 col-sm-12 col-xs-12">
			         	<table class="table-list table table-bordered table-condensed himokuMeisaiTable" id="himokuMeisaiTable">
			                <thead>
			                    <tr>
			                    	<th rowspan="2" style="vertical-align:middle;">
			                    		<input class="checkAll" type="checkbox"></th>
			                        <th rowspan="2" style="vertical-align:middle;">費目</th>
			                        <th rowspan="2" style="vertical-align:middle;">業者</th>
			                        <th rowspan="2" style="vertical-align:middle;">請求年月</th>
			                        <th rowspan="2" style="vertical-align:middle;">単位単価</th>
			                        <th rowspan="2" style="vertical-align:middle;">単価</th>
			                        <th colspan="5">内訳情報</th>
			                        <th rowspan="1">重量</th>
			                        <th rowspan="2" style="vertical-align:middle;">内訳</th>
			                    </tr>
			                    <tr>
			                        <th rowspan="1">基本</th>
			                        <th rowspan="1">空トン</th>
			                        <th rowspan="1">長尺</th>
			                        <th rowspan="1">休日</th>
			                        <th rowspan="1">時間外</th>
			                        <th>金額</th>
			                    </tr>			                    
			                </thead>
			                <tbody>
			                	<c:forEach items="${item.selectDetail}" var="e">
				                	<tr>
				                		<td class="parts">
				                		<input name="meisaiCheck" type="checkbox">
				                		</td>
				                        <td>
				                        	<input type="text" value="${e.himokuCd}" maxlength="2" class="form-control input-xsmall himokuCd">
				                        	<input type="hidden" value="${e.himokuCd}" class=oldHimokuCd>
				                        	<input type="hidden" value="${e.bodyTeiseiKbn}" class="bodyTeiseiKbn">
				                        	<input type="hidden" value="${e.bodyTeiseiKaisu}" class="bodyTeiseiKaisu">
				                        	<input type="hidden" value="update" class="action">
				                        </td>
				                        <td><input type="text" value="${e.gyoshaCd}" maxlength="3" class="form-control input-xsmall gyoshaCd"></td>
				                        <td>
				                        	<input type="text" value="${e.seikyuNengetsu}" maxlength="6" class="form-control input-small seikyuNengetsu">
				                        	<input type="hidden" value="${e.seikyuNengetsu}" class=oldSeikyuNengetsu>
				                        </td>
				                        <td><input type="text" value="${e.tankaTani}" maxlength="1" class="form-control input-xsmall tankaTani"></td>
				                        <td><input type="text" value="${e.tanka}" maxlength="15" class="form-control input-small number tanka" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"></td>
				                        <td>
					                        <input type="text" value="${e.uchiwakeBaseJuryo}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeBaseJuryo"><hr>
					                        <input type="text" value="${e.uchiwakeBaseKingaku}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeBaseKingaku">
				                        </td>
				                        <td>
				                        	<input type="text" value="${e.uchiwakeKutonJuryo}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeKutonJuryo"><hr>
				                        	<input type="text" value="${e.uchiwakeKutonKingaku}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeKutonKingaku">
				                        </td>
				                        <td>
				                        	<input type="text"  value="${e.uchiwakeChoJakuJuryo}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeChoJakuJuryo"><hr>
				                        	<input type="text" value="${e.uchiwakeChojakuKingaku}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeChojakuKingaku">
				                        </td>
				                        <td>
				                        	<input type="text" value="${e.uchiwakeJikangaiJuryo}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeJikangaiJuryo"><hr>
				                        	<input type="text" value="${e.uchiwakeJikagaiKingaku}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeJikagaiKingaku">
				                        </td>
				                        <td>
				                        	<input type="text" value="${e.uchiwakeSonotaJuryo}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeSonotaJuryo"><hr>
				                        	<input type="text" value="${e.uchiwakeSonotaKingaku}" maxlength="15" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" class="form-control input-small number uchiwakeSonotaKingaku">
				                        </td>
				                        <td>
					                        <input type="text" value="${e.totalJuryo}" maxlength="15" class="form-control input-small number" disabled><hr>
					                        <input type="text" value="${e.totalKingaku}" maxlength="15" class="form-control input-small number" disabled>
				                        </td>
				                        <td>
				                        	<c:if test='${e.himokuCd.startsWith("Z")}'>
				                        		<a class="btn btn-default" href="<c:url value="/NFMYGX0160/init"/>">内訳</a> 
				                        	</c:if>
				                        </td>
				                    </tr>
			                    </c:forEach>
			                </tbody>
			            </table>
		         </div>
		        
	         </div>
	          <br>
	         <div class="row">
	            <div class="col-md-12 col-sm-12 col-xs-12">
                 	<table class="table-single table-bordered table-condensed col-md-12">
	                  <tr>
	                     <td class="caption col-md-2 required">修正理由</td>
	                     <td class="col-md-10"><input type="text" class="form-control input-nolimit string-wide" id="teiseiRiyu" maxlength="256" placeholder="256 characters">
	                     </td>
	                  </tr>
	               </table>
                 </div>
	         </div>
	         <br>
	         <div class="row">
	         	<div class = "col-sm-12 col-xs-12">
	         		<button class="btn btn-primary updateButton" type="submit"><i class="ic-commit"></i>修正</button>
	         		<button class="btn btn-default cancelButton">キャンセル</button> 
	         	</div>
	         </div>
		</div>

	</div>
<!-- /. PAGE WRAPPER  -->
</div>
<script src="<c:url value="/resources/js/nfmygx0140.js"/>"></script>
</body>
</html>
