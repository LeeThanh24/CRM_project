$(document).ready(function () {


    $('.btn-xoa').click(function () {
        const id = $(this).attr("id")
        const This = $(this)
        $.ajax({
            method : 'GET',
            url  : `http://localhost:8080/api/roles/delete?id=${id}`,

        }).done(function (data)
        {
           if (data.data )
           {
               This.closest('tr').remove()
               console.log("Delete successfully !")
           }else
           {
               alert("This role has been using")
               console.log("Delete unsuccessfully !")
           }
        })
    })

    function checkNullUndefined(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }

    $('#btn-add').click(function (e)
    {
        const name = $('#name').val()
        const desc = $('#desc').val()
        if (checkNullUndefined(name) || checkNullUndefined(desc))
        {
            alert("Added unsuccessfully")
            e.preventDefault()

        }else
        {
            e.preventDefault() //chan tat ca cac su kien mac dinh
            $.ajax({
                method : 'POST',
                url  : `http://localhost:8080/api/roles/add`,
                data :{
                    'name' :name,
                    'desc' : desc
                }
            }).done(function (data)
            {
                alert("Added successfully")
            })

        }

    })



})