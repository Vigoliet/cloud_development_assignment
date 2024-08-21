# Song application

This is a simple song application that allows you to add, and get songs from a database. 
Along with XRay to trace the application methods.

## Tutorial
1. <a href="https://docs.aws.amazon.com/xray/latest/devguide/xray-daemon-local.html#xray-daemon-local-windows">AWS X-Ray Daemon</a> is a software application that listens for traffic on UDP port 2000, gathers raw segment data, and relays it to the AWS X-Ray API. The daemon works with the AWS X-Ray SDKs and must be running so that the SDKs can send data to it.

2. After downloading - Make sure to unzip the file and navigate to the folder in powershell.

3. Run the following command to start the daemon:
```bash
.\xray_windows.exe -o -n eu-north-1
```
>Make sure to have the corresponding dependencies in your project.