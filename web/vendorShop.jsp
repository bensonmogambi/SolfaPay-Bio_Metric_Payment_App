<%-- 
    Document   : vendorShop
    Created on : Apr 27, 2015, 12:15:54 AM
    Author     : arjunmehrotra
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Random"%>
<%@page import="MDT.FingerPrint.cmu.Catalog"%>
<%@page import="MDT.FingerPrint.cmu.Item"%>
<%@page import="java.util.Iterator"%>
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
        <script type="text/javascript" language="javascript" src="ajax1.js"></script>
        <script type="text/javascript" language="javascript" src="cart.js"></script>
        <title>PayBM: Vendor Side Application</title>
    </head>
    <body>
        <div data-role="page">
            <div data-role="header" data-theme="b" data-position="fixed">
                <a href="index.jsp" data-icon="back" class="ui-btn-Left">Back</a>
                <h1>PayBM: Vendor Side Application</h1>
            </div><!-- /header -->

            <div role="main" class="ui-content ui-grid-b" data-theme="b" data-ajax="false" >
                <% Random r = new Random();
                    int rand = r.nextInt(1000000000);
                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date date = new Date();
                %>
                <div class="ui-grid-a ui-responsive">
                    <div class="ui-block-a">
                        <div class="ui-bar ui-bar-b">
                            <h3>Vendor Details</h3>
                        </div>
                        <div class="ui-field-contain">
                            <label for="vendorName">Vendor Name:</label>
                            <input name="vendorName" id="vendorName" placeholder="Vendor Name" type="text" class="ui-input-text" value="Starbucks Coffee Company">
                        </div>
                        <div class="ui-field-contain">
                            <label for="transactionNumber">Transaction Number:</label>
                            <input  name="transactionNumber" id="transactionNumber" placeholder="Transaction Number"  type="text" value="<%=rand%>">
                        </div>
                        <div class="ui-field-contain">
                            <label for="transactionDate">Transaction Date:</label>
                            <input data-role="date" type="text" name="transactionDate" id="transactionDate" placeholder="mm/dd/yyyy" value="<%=dateFormat.format(date)%>">
                        </div>
                    </div>
                    <div class="ui-block-b">
                        <div class="ui-bar ui-bar-b">
                            <h3>Shopping Cart</h3>
                        </div>
                        <ul id="contents">
                        </ul>
                        Total cost: <span id="total">$0.00</span>
                        <input type ="button" id="sb" value="Process Transaction"/>
                    </div>
                </div>
                <div class="ui-grid-solo">
                    <div class="ui-bar ui-bar-b">
                        <h3>Items</h3>
                    </div>
                    <table data-role="table" id="items" class="ui-responsive table-stroke">
                        <thead>
                            <tr>
                                <th data-priority="1">Name</th>
                                <th data-priority="1">Description</th>
                                <th data-priority="1">Price</th>
                                <th data-priority="1">Add To Cart</th>
                                <th data-priority="1">Delete From Cart</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Iterator<Item> I = new Catalog().getAllItems().iterator(); I.hasNext();) {
                                    Item item = I.next();
                            %>
                            <tr>
                                <td><%= item.getName()%></td>
                                <td><%= item.getDescription()%></td>
                                <td><%= item.getFormattedPrice()%></td>
                                <td><button onclick="addToCart('<%= item.getCode()%>')" class="ui-btn-mini">Add to Cart</button></td>
                                <td><button onclick="deleteFromCart('<%= item.getCode()%>')" class="ui-btn-mini">Delete From Cart</button></td>
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
</html>
