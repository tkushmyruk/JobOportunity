This guide will help you start up and customise this simple jobs notification service.

You will receive notifications every **30 minutes** for any newly added opportunities that match filters.

## Prerequisites

To build & run the project you should have installed

- JDK 20

## Downloading files

If Github release is available

- download `jar` from Github release. Also, download `start.bat` / `start.sh` scripts.

Else download source code and build locally:

- clone repository locally `git clone https://github.com/tkushmyruk/JobOportunity`

### Building locally

- execute `mvn package`. This will place `jar` in `target` folder.

## Start

- use script
    - `start.bat` - for Windows
    - `start.sh` - for Linux/macOS
- or run command
  `java -jar PositionNotificationSystem*.jar`
- **Note,** you might need to
    - edit the path to `jar` (see comments in the script)
    - explicitly provide the path to **jdk20**, if your default system `java` version is different

### Configuration

Once the service is up and running you should provide some configuration and enable the notifications.
There is a UI for this, so follow the steps

1. open http://localhost:2244
1. provide your **cookie** (you could copy it from your browser when interacting with corresponding system)
1. open http://localhost:2244/emails
1. add **emails** that the service should send notifications to
1. Finally, click **Enable job** button at http://localhost:2244

### Current limitations

Teams Notification channel and search filters are pre-set. If you want to create and use a separate channel or
retrieve other filters, check properties

- `client.post.baseUrl` (this is where search filters are extracted from)
- `client.post.teamsUrl` (teams channel webhook)