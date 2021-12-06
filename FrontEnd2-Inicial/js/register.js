$(document).ready(function() {
    $("#crear").click(function() {
        let name = $.trim($("#nombre").val());
        let email = $.trim($("#correo").val());
        let password = $.trim($("#contraseña").val());
        let password2 = $.trim($("#confirmar").val());

        if (
            name != null &&
            email != null &&
            password != null &&
            password2 != "" &&
            email.indexOf("@") != -1 &&
            email.indexOf(".") != -1
        ) {
            if (password === password2) {
                $.ajax({
                    url: `http://localhost:8084/api/user/emailexist/${email}`,
                    type: "GET",
                    success: function(result) {
                        if (result == true) {
                            alert("Correo ya existe");
                            clearInputs();
                            return false;
                        } else {
                            $.ajax({
                                url: "http://localhost:8084/api/user/new",
                                type: "POST",
                                data: JSON.stringify({
                                    email: email,
                                    password: password,
                                    name: name,
                                }),
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                cache: false,
                                success: function() {
                                    alert("Cuenta creada de forma correcta");
                                    location.href = "index.html";

                                },
                            });


                        }
                    },
                });

            } else {
                alert("Las contraseñas no coinciden");
                clearInputs()


                return false;
            }
        } else {
            re = /^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if (
                name == "" ||
                email == "" ||
                password == "" ||
                password2 == "") {
                alert("Todos los campos son obligatorios");

            } else if (!re.exec(email)) {
                alert("Correo No valido");

            }


        }



    })
})

function clearInputs() {
    $("#correo").value("");
    $("#nombre").value("");
    $("#contraseña").value("");
    $("#confirmar").value("");
    $("#zona").value("");
}