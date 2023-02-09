// Timestamp of cart that page was last updated with
var lastCartUpdate = 0;

/*
 * Adds the specified item to the shopping cart, via Ajax call
 * itemCode - product code of the item to add
 */
function addToCart(itemCode) {

   var req = newXMLHttpRequest();

    req.onreadystatechange = getReadyStateHandler(req, updateCart);
    
    req.open("POST", "CartServlet", true);
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send("action=add&item=" + itemCode);
}

function deleteFromCart(itemCode) {

    var req = newXMLHttpRequest();

    req.onreadystatechange = getReadyStateHandler(req, updateCart);

    req.open("POST", "CartServlet", true);
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.send("action=remove&item=" + itemCode);
}

/*
 * Update shopping-cart area of page to reflect contents of cart
 * described in XML document.
 */
function updateCart(cartXML) {
    var cart = cartXML.getElementsByTagName("cart")[0];
    var generated = cart.getAttribute("generated");
    if (generated > lastCartUpdate) {
        lastCartUpdate = generated;
        var contents = document.getElementById("contents");
        contents.innerHTML = "";

        var items = cart.getElementsByTagName("item");
        for (var I = 0; I < items.length; I++) {

            var item = items[I];
            var name = item.getElementsByTagName("name")[0].firstChild.nodeValue;
            var quantity = item.getElementsByTagName("quantity")[0].firstChild.nodeValue;

            var listItem = document.createElement("li");
            listItem.appendChild(document.createTextNode(name + " x " + quantity));
            contents.appendChild(listItem);
        }

    }

    document.getElementById("total").innerHTML = cart.getAttribute("total");
}

$(document).ready(function(){
    $(function(){
        $("#sb").click(function(e){
            var vendorName = $("#vendorName").val();
            var transactionNumber = $("#transactionNumber").val();
            var transactionDate = $("#transactionDate").val();
            var total = document.getElementById("total").innerHTML;
            var content = document.getElementById("contents").innerHTML;
            window.location = "ProcessPaymentServlet?vendorName="+vendorName+"&transactionNumber="+transactionNumber+
                    "&transactionDate="+transactionDate+"&total="+total+"&content="+content;
//            $.ajax({
//                type: "GET",
//                    url: "ProcessPaymentServlet",
//                    data:{
//                        vendorName: vendorName,
//                        transactionNumber: transactionNumber,
//                        transactionDate: transactionDate,
//                        total: total,
//                        content: content   
//                    },
//                    success: function(data){
//                        window.location = data;
////                        alert("Success");
//                    },
//                    error: function () {
//                        alert("failure")
//                }
//            });
        });
    });
});
