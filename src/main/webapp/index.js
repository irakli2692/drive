/**
 * @author Davit Abulashvili
 */

var metadata = {}

function addFormParam() {
    $('.alert').addClass('hide')
    var keyEl = $("#key");
    var valueEl = $("#value")
    var key = keyEl.val()
    var value = valueEl.val()

    if (metadata[key]) {
        error('Property with this key already exists')
        return
    }

    if (!key || !value) {
        error('Key or value must not be null')
        return
    }

    var newDiv = document.createElement('div')
    $(newDiv).addClass('row vertical-divider')
    newDiv.id = key
    newDiv.innerHTML = '<div class="col-xs-5"><input class="form-control" type="text" value="' + key + '" disabled>' +
        '</div><div class="col-xs-5">' +
        '<input class="form-control" type="text" value="' + value + '" disabled>' +
        '</div><div class="col-xs-2"><button type="button" class="btn btn-primary" onclick="deleteFormParam(this)">' +
        '<i class="glyphicon glyphicon-minus"></i></button></div>'
    $('#props').append(newDiv)

    keyEl.val('')
    valueEl.val('')
    metadata[key] = value
}

function deleteFormParam(button) {
    var div = button.parentNode.parentNode
    delete metadata[div.id]
    div.parentNode.removeChild(div)
}

function uploadFile() {
    $('.alert').addClass('hide')
    var formData = new FormData()
    var files = $('#file').prop("files")
    if (!files[0]) {
        error('You must choose file')
        return
    }
    formData.append("_file", files[0])
    for (var i in metadata) {
        formData.append(i, metadata[i])
    }

    $.ajax({
        url: 'file/upload',
        type: 'POST',
        data: formData,
        mimeType: "multipart/form-data",
        contentType: false,
        cache: false,
        processData: false,
        success: function (data, textStatus, jqXHR) {
            console.log(jqXHR.responseText)
            var file = $("#file")
            file.replaceWith(file.clone())
            $("#fileText").val('')
            for (var i in metadata) {
                $("#" + i).remove()
            }
            metadata = {}
        },
        error: function (jqXHR, textStatus, errorThrown) {
            error('Error while uploading file')
        }
    });
}

function error(text) {
    var el = $('.alert')
    el.removeClass('hide')
    el.text(text)
}