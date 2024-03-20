import express from 'express';

const app = express();

app.get('/', (req, res) => {
    res.send("Hello World");
});

const server = app.listen(8000, () => {
    console.log(`Server is running on Port 8000`);
});

// Handling uncaught exceptions
process.on('uncaughtException', (error) => {
    console.error('Uncaught Exception:', error);
    server.close(() => {
        console.log('Server closed due to uncaught exception.');
        process.exit(1); // Exiting with a non-zero code indicates an error
    });
});

// Handling graceful shutdown
process.on('SIGINT', () => {
    console.log('Received SIGINT. Closing server gracefully...');
    server.close(() => {
        console.log('Server closed.');
        process.exit(0);
    });
});

process.on('SIGTERM', () => {
    console.log('Received SIGTERM. Closing server gracefully...');
    server.close(() => {
        console.log('Server closed.');
        process.exit(0);
    });
});
