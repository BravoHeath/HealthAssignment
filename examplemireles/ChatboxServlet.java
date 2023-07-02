$(document).ready(function() {
        var chatMessages = $('#chatMessages');
        var chatForm = $('#chatForm');
        var messageInput = $('#messageInput');

        chatForm.submit(function(e) {
        e.preventDefault();
        var message = messageInput.val();
        if (message.trim() !== '') {
        sendMessage(message);
        messageInput.val('');
        }
        });

        function sendMessage(message) {
        var messageElement = $('<div>').text(message);
        chatMessages.append(messageElement);

        // Send the chat message to the ChatServlet using AJAX
        $.ajax({
        url: '/chat',  // Update with the URL or servlet mapping for the ChatServlet
        type: 'POST',
        data: { message: message },
        success: function(response) {
        // Handle the server response if needed
        // ...
        },
        error: function(xhr, status, error) {
        // Handle errors if needed
        // ...
        }
        });
        }
        });
