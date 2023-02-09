<%-- 
    Document   : confirmOrder
    Created on : Apr 27, 2015, 2:46:48 AM
    Author     : arjunmehrotra
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="MDT.FingerPrint.cmu.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=2" CONTENT="no-cache">
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
        <link rel="stylesheet" href="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.css">
        <link rel="stylesheet" href="appcss.css" type = "text/css"/>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <script src="http://cdn.rawgit.com/jquery/jquery-ui/1.10.4/ui/jquery.ui.datepicker.js"></script>
        <script id="mobile-datepicker" src="http://cdn.rawgit.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-theme="b" data-position="fixed">
                <h1>PayBM: Vendor Side Application</h1>
            </div><!-- /header -->

            <div role="main" class="ui-content ui-grid-b" data-theme="b" data-ajax="false" >
                <% Order o = (Order) request.getAttribute("order");%>
                <div class="ui-grid-a ui-responsive">
                    <div class="ui-block-a">
                        <div class="ui-bar ui-bar-b">
                            <h3>Vendor Details</h3>
                        </div>
                        <div class="ui-field-contain">
                            <label for="vendorName">Vendor Name:</label>
                            <input disabled="true" name="vendorName" id="vendorName" value="<%=o.getVendorName()%>" type="text" class="ui-input-text">
                        </div>
                        <div class="ui-field-contain">
                            <label for="transactionNumber">Transaction Number:</label>
                            <input  disabled="true" name="transactionNumber" id="transactionNumber" value="<%=o.getTranNumber()%>"  type="text">
                        </div>
                        <div class="ui-field-contain">
                            <label for="transactionDate">Transaction Date:</label>
                            <input disabled="true" data-role="date" type="text" name="transactionDate" id="transactionDate" value=" <%=o.getTranDate()%>">
                        </div>
                        <div class="ui-field-contain">
                            <label for="total">Total Amount:</label>
                            <input disabled="true" data-role="date" type="text" name="total" id="total" value=" <%=o.getTotal()%>">
                        </div>
                    </div>
                    <form action="ValidateTransaction" method="Get" type=""input>
                        <div class="ui-block-b">
                            <div class="ui-bar ui-bar-b">
                                <h3>Validate Transaction</h3>
                            </div>
                            <div class="ui-field-contain">
                                <input type="hidden" name="vendorName" id="vendorName" value="<%=o.getVendorName()%>">
                                <input type="hidden" name="transactionNumber" id="transactionNumber" value="<%=o.getTranNumber()%>">
                                <input type="hidden" name="total" id="total" value=" <%=o.getTotal()%>">
                                <input type="hidden" name="transactionDate" id="transactionDate" value=" <%=o.getTranDate()%>">
                                <label for="pin">Enter Pin:</label>
                                <input type="text" name="pin" id="pin">
                            </div>
                            <input type ="submit" id="validate" value="Validate Transaction"/>
                        </div>
                    </form>
                </div>
                <div class="ui-grid-solo">
                    <div class="ui-bar ui-bar-b">
                        <h3>Items</h3>
                    </div>
                    <table data-role="table" id="items" class="ui-responsive table-stroke">
                        <thead>
                            <tr>
                                <th data-priority="1">S. No.</th>
                                <th data-priority="1">Description</th>
                                <th data-priority="1">Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Iterator i = o.getItems().entrySet().iterator();
                                int count = 0;
                                for (String key : o.getItems().keySet()) {
                            %>
                            <tr>
                                <td><%=++count%></td>
                                <td><%= key%></td>
                                <td><%= o.getItems().get(key)%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>

                </div>
                <div class="ui-grid-b ui-responsive">
                    <div class="ui-block-a">

                    </div>
                    <div class="ui-block-b">

                    </div>
                    <div class="ui-block-c">

                    </div>

                    <div class="ui-block-a">

                    </div>
                    <div class="ui-block-b">
                    </div>
                    <div class="ui-block-c">

                    </div>
                </div>
                <div data-role="footer" data-position="fixed" data-theme="b">
                    <div data-role="navbar">
                        <ul>
                            <li><a href="#" data-icon="comment">About</a></li>
                            <li><a href="#" data-icon="mail">Help</a></li>
                            <li><a href="#" data-icon="user">Careers</a></li>
                            <li><a href="#" data-icon="info">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div><!-- /footer -->
            </div>
    </body>
</body>
</html>
