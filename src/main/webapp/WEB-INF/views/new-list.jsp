<%@ page import="java.util.List" %>
<%@ page import="ru.transasia.mvnproject1.entities.Part" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="ru.transasia.mvnproject1.entities.FilterValues" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 23.02.2018
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of parts</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            border: 3px solid lightblue;
            margin: 0 auto;
            height: auto;
            width: 70%;
        }

        th {
            background-color: lightblue;
            border-bottom: 2px solid lightgray;
            text-align: left;
        }

        td:nth-child(1) {
            width: 200px;
        }

        tr {
            border-bottom: 1px solid lightgray;
        }

        td {
            height: 25px;
        }

        button {
            background-color: lightblue;

        }

        #filterButton {
            background-color: lightblue;

        }

        .applyFilter {
            text-align: center;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        .outputMessage {
            text-align: center;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        tr,
        td,
        th {
            border: 1px solid lightgray;
            padding-left: 7px;
        }

        .PnumRes {
            width: 10%;
        }

        .PnameRes {
            width: 40%;
        }

        .VendorRes {
            width: 15%;
        }

        .QtyRes {
            width: 5%;
            text-align: center;
        }

        .ShpdRes {
            width: 15%;
        }

        .RcvdRes {
            width: 15%;
        }

    </style>
</head>
<body>
    <fmt:setLocale value = "en_US" scope="session"/>
    <div>

    </div>
    <!-- filter table -->
    <table border="1" width = 40% cellspacing="0" cellpadding="3" >
     
        <!-- filter-->
        <form action="/filtered" id = "01" method="post">

            <tr>
                <th colspan="5">Filter</th>
            </tr>
            <tr>
                <td>
                    <label>PN</label>
                </td>
                <td>
                    <input size = "35" value = "<c:out value="${parameterMap['partNumber']}"/>" type="text" name="partNumber"><br />
                </td>
            </tr>
            <tr>
                <td>
                    <label>Part Name:</label>
                </td>
                <td>
                    <input size = "35" value = "<c:out value="${parameterMap['partName']}"/>" type="text" name="partName"><br />
                </td>
            </tr>
            <tr>
                <td>
                    <label>Vendor:</label>
                </td>
                <td>
                    <input size = "35" value = "<c:out value="${parameterMap['vendor']}"/>" type="text" name="vendor"><br />
                </td>
            </tr>
            <tr>
                <td>
                    <label>Qty:</label>
                </td>
                <td>
                    <input size = "6" value = "<c:out value="${parameterMap['quantity']}"/>" type="text" name="quantity"><br />
                </td>
            </tr>
            <tr>
                <td>
                    <label>Shipped:</label>
                </td>
                <td>
                    after <input size = "10" value = "<c:out value="${parameterMap['shpdAfter']}"/>" type="text" name="shippedAfter">
                    before <input size = "10" value = "<c:out value="${parameterMap['shpdBefore']}"/>" type="text" name="shippedBefore"><br />
                </td>
            </tr>
            <tr>
                <td>
                    <label>Received:</label>
                </td>
                <td>
                    after <input size = "10" value = "<c:out value="${parameterMap['rcvdAfter']}"/>" type="text" name="receivedAfter">
                    before <input size = "10" value = "<c:out value="${parameterMap['rcvdBefore']}"/>" type="text" name="receivedBefore"><br />
                </td>
            </tr>            
        </form>
    </table>
<div class = applyFilter>
    <button id = "filterButton" type="submit" form = "01">Filter</button>
</div>
<div>
    <form action="/list" id = "02" method="GET">
        
    </form>

    <!-- output filtered parts table -->
    <table>
        <tr>
                <!--sort by column-->
                <th class="PnumRes" ><button type="submit" form = "01" name="sortByColumn" value="1">PN</button></th>
                <th class="PnameRes" ><button type="submit" form = "01" name="sortByColumn" value="2">Part Name</button></th>
                <th class="VendorRes"><button type="submit" form = "01" name="sortByColumn" value="3">Vendor</button></th>
                <th class="QtyRes"><button type="submit" form = "01" name="sortByColumn" value="4">Qty</button></th>
                <th class="ShpdRes"><button type="submit" form = "01" name="sortByColumn" value="5">Shipped</button></th>
                <th class="RcvdRes"><button type="submit" form = "01" name="sortByColumn" value="6">Received</button></th>
        </tr>

        <c:forEach items="${parts}" var="s">
            <tr>
                <td>${s.getPnumber()}</td>
                <td>${s.getPname()}</td>
                <td>${s.getVendor()}</td>
                <td>${s.getQty()}</td>
                
                <td><fmt:formatDate value="${s.getShipped()}" pattern="MMM dd, yyyy"/></td>
                <td><fmt:formatDate value="${s.getReceived()}" pattern="MMM dd, yyyy"/></td>
            </tr>
        </c:forEach>
    </table>
    
</div>

</body>
</html>