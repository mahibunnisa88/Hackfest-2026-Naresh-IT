<%@ page import="java.util.*" %>
<%@ page import="com.nit.model.Food" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Food</title>
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

        .card-custom{
            border:none;
            border-radius:18px;
            box-shadow:0 4px 14px rgba(0,0,0,0.08);
            overflow:hidden;
            background:#ffffff;
        }

        .card-head{
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

        .request-btn{
            background:#cfe2ff;
            border:none;
            color:#2c5aa0;
            font-weight:600;
            padding:10px 24px;
            border-radius:10px;
        }

        .request-btn:hover{
            background:#b6d4fe;
        }

        .confirm-btn{
            background:#d1fae5;
            border:none;
            color:#065f46;
            font-weight:600;
            padding:10px 20px;
            border-radius:10px;
        }

        .confirm-btn:hover{
            background:#b7f3d8;
        }

        .close-btn{
            background:#e2eafc;
            border:none;
            color:#3d5a80;
            font-weight:600;
            padding:10px 20px;
            border-radius:10px;
        }

        .close-btn:hover{
            background:#d0dbf5;
        }

        .details-box{
            background:#f8fbff;
            border-radius:12px;
            border:1px solid #dbe7ff;
        }

        .proof-box{
            max-width:700px;
            margin:20px auto;
            background:#ffffff;
            border-radius:18px;
            box-shadow:0 4px 14px rgba(0,0,0,0.08);
            padding:25px;
        }

        .upload-btn{
            background:#cfe2ff;
            border:none;
            color:#2c5aa0;
            font-weight:600;
        }

        .upload-btn:hover{
            background:#b6d4fe;
        }

        .back-btn{
            background:#e2eafc;
            border:none;
            color:#3d5a80;
            font-weight:600;
        }

        .back-btn:hover{
            background:#d0dbf5;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center title mb-4">Available Food Items</h2>

    <%
        String requestSuccess = (String) session.getAttribute("requestSuccess");

        if(requestSuccess != null){
    %>
        <div class="proof-box text-center">
            <div class="alert alert-success fw-bold">
                <%= requestSuccess %>
            </div>

            <form action="uploadProof" method="post" enctype="multipart/form-data">
                <div class="mb-3 text-start">
                    <label class="form-label fw-semibold">Add Image Proof</label>
                    <input type="file" name="proofImage" class="form-control" accept="image/*" required>
                </div>

                <button type="submit" class="btn upload-btn me-2">Upload Proof</button>
                <a href="viewFood.jsp" class="btn back-btn">Back</a>
            </form>
        </div>
    <%
        }
    %>

    <%
        List<Food> foodList = (List<Food>) application.getAttribute("foodList");

        if(foodList == null || foodList.size() == 0){
    %>
        <div class="alert alert-light text-center shadow-sm rounded-4">
            No food items available
        </div>
    <%
        } else {
            for(int i = 0; i < foodList.size(); i++){
                Food food = foodList.get(i);
    %>

    <div class="card card-custom mb-4">
        <div class="card-head">
            Food Item <%= i + 1 %>
        </div>

        <div class="card-body p-4">
            <div class="row align-items-center">
                <div class="col-md-9">
                    <div class="row mb-2">
                        <div class="col-md-4 label">Restaurant</div>
                        <div class="col-md-8 value">: <%= food.getRestaurantUser() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Food Name</div>
                        <div class="col-md-8 value">: <%= food.getFoodName() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Quantity</div>
                        <div class="col-md-8 value">: <%= food.getQuantity() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Expires In Hours</div>
                        <div class="col-md-8 value">: <%= food.getExpiresInHours() %></div>
                    </div>
                </div>

                <div class="col-md-3 d-flex justify-content-center align-items-center">
                    <button class="btn request-btn"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#details<%= i %>">
                        Request
                    </button>
                </div>
            </div>

            <div class="collapse mt-3" id="details<%= i %>">
                <div class="details-box p-3">
                    <h5 class="text-center text-primary mb-3">Food Request Details</h5>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Restaurant</div>
                        <div class="col-md-8 value">: <%= food.getRestaurantUser() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Food Name</div>
                        <div class="col-md-8 value">: <%= food.getFoodName() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Quantity</div>
                        <div class="col-md-8 value">: <%= food.getQuantity() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Expires In Hours</div>
                        <div class="col-md-8 value">: <%= food.getExpiresInHours() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Phone</div>
                        <div class="col-md-8 value">: <%= food.getPhone() %></div>
                    </div>

                    <div class="row mb-2">
                        <div class="col-md-4 label">Address</div>
                        <div class="col-md-8 value">: <%= food.getAddress() %></div>
                    </div>

                    <div class="text-center mt-3">
                        <form action="requestFood" method="post" style="display:inline;">
                            <input type="hidden" name="index" value="<%= i %>">
                            <button type="submit" class="btn confirm-btn me-2">Confirm Request</button>
                        </form>

                        <button class="btn close-btn"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#details<%= i %>">
                            View Back
                        </button>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <%
            }
        }
    %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>