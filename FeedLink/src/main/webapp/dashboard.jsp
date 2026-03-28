<%@ page import="java.util.*" %>
<%@ page import="com.nit.model.ProofRecord" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body{
            background-color:#f4f6fb;
        }

        .title{
            color:#5f7fb3;
            font-weight:700;
        }

        .dash-card{
            border:none;
            border-radius:18px;
            box-shadow:0 4px 14px rgba(0,0,0,0.08);
            overflow:hidden;
            background:#ffffff;
        }

        .dash-head{
            background:#e8f1ff;
            color:#4a6fa5;
            font-weight:700;
            text-align:center;
            padding:14px;
        }

        .label{
            font-weight:600;
            color:#6c757d;
        }

        .value{
            color:#2f3e4d;
        }

        .proof-img{
            width:100%;
            max-height:260px;
            object-fit:cover;
            border-radius:12px;
            border:1px solid #dbe7ff;
        }

        .top-btn{
            background:#e2eafc;
            border:none;
            color:#3d5a80;
            font-weight:600;
        }

        .top-btn:hover{
            background:#d0dbf5;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center title mb-4">Proof Dashboard</h2>

    <div class="text-center mb-4">
        <a href="viewFood.jsp" class="btn top-btn">Back to Food Items</a>
    </div>

    <%
        String uploadMsg = (String) session.getAttribute("uploadMsg");
        if(uploadMsg != null){
    %>
        <div class="alert alert-success text-center fw-bold">
            <%= uploadMsg %>
        </div>
    <%
            session.removeAttribute("uploadMsg");
        }

        List<ProofRecord> proofList = (List<ProofRecord>) application.getAttribute("proofList");

        if(proofList == null || proofList.size() == 0){
    %>
        <div class="alert alert-light text-center shadow-sm rounded-4">
            No uploaded proofs available
        </div>
    <%
        } else {
            for(ProofRecord record : proofList){
    %>

    <div class="card dash-card mb-4">
        <div class="dash-head">
            Requested Food Proof
        </div>

        <div class="card-body p-4">
            <div class="row g-4">
                <div class="col-md-7">
                    <div class="row mb-2">
                        <div class="col-md-4 label">Restaurant</div>
                        <div class="col-md-8 value">: <%= record.getRestaurantUser() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">NGO Volunteer</div>
                        <div class="col-md-8 value">: <%= record.getNgoUser() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Food Name</div>
                        <div class="col-md-8 value">: <%= record.getFoodName() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Quantity</div>
                        <div class="col-md-8 value">: <%= record.getQuantity() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Expires In Hours</div>
                        <div class="col-md-8 value">: <%= record.getExpiresInHours() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Restaurant Phone</div>
                        <div class="col-md-8 value">: <%= record.getPhone() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Restaurant Address</div>
                        <div class="col-md-8 value">: <%= record.getAddress() %></div>
                    </div>
                </div>

                <div class="col-md-5">
                    <img src="<%= record.getProofImagePath() %>" alt="Proof Image" class="proof-img">
                </div>
            </div>
        </div>
    </div>

    <%
            }
        }
    %>
</div>

</body>
</html>