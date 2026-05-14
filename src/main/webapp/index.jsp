<html>

<head>

    <title>Hospital Management</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

    <div class="container mt-5">

        <div class="card shadow p-4">

            <h2 class="mb-4 text-primary">

                Hospital Management System

            </h2>

            <form action="<%= request.getContextPath() %>/add" method="post">

                <div class="mb-3">

                    <label class="form-label">

                        Name

                    </label>

                    <input type="text" name="name" class="form-control">

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Age

                    </label>

                    <input type="number" name="age" class="form-control">

                </div>

                <div class="mb-3">

                    <label class="form-label">

                        Disease

                    </label>

                    <input type="text" name="disease" class="form-control">

                </div>

                <button class="btn btn-primary">

                    Add Patient

                </button>

                <a href="view" class="btn btn-success">

                    View Patients

                </a>

            </form>

        </div>

    </div>

</body>

</html>