$(document).ready(function () {
    $('.btn-xoa').click(function () {
        const id = $(this).attr("id")
        const This = $(this)
        console.log(id)
        $.ajax({
            method : 'POST',
            url  : `http://localhost:8080/api/tasksStatusJobsUsers/delete`,
            data :
                {
                    id:id
                }

        }).done(function (data)
        {
            if (data.data )
            {
                This.closest('tr').remove()
                console.log("Delete successfully !")
            }else
            {
                alert("This task has been using")

                console.log("Delete unsuccessfully !")
            }
        })
    })

    function checkNullUndefined(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }

    $('.btn-add').click(function (e)
    {

        const job_id = $('#jobs').find('option:selected').attr('job_id')
        const taskName = $('#taskName').val()
        const doer_id = $('#doer').find('option:selected').attr('doer_id')
        const start = $('#start').val()
        const end = $('#end').val()
        const status_id = $('#status').find('option:selected').attr('status_id')

        if (checkNullUndefined(taskName) || checkNullUndefined(start) || checkNullUndefined(end))
        {
            alert("Added unsuccessfully")
            e.preventDefault()

        }else
        {
            e.preventDefault() //chan tat ca cac su kien mac dinh
            $.ajax({
                method : 'POST',
                url  : `http://localhost:8080/api/tasksStatusJobsUsers/add`,
                data :{
                    'taskName' :taskName,
                    'start' : start,
                    'end' : end,
                    'user_id' : doer_id,
                    'status_id' : status_id,
                    'job_id' : job_id
                }
            }).done(function (data)
            {
                alert("Added successfully")
            })

        }

    })



})