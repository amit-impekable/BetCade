# BetCade - Android

A private market application to provide user access to gambling applications that may not be otherwise accessible in standard markets.  The application is modeled after the more recent Google Play store editions, providing a dashboard screen that highlights categories and spotlight content, individual lists of application (by category or search), a detailed application information area and some other ansciallary areas.  The application monitors the active installations and provides real-time feedback to the user about the inventory of available and installed application as well as notifying users' of updates, critical or otherwise.  Since the application will be related to a gamling ecosystem, part of it's design requires some divergence from the original play store, mandating a registration process be completed prior to accessing the store's content areas.  For more information, please see the [Wiki](../../wiki).

## Project Phases

The project will be delivered in multiple phases, each adding more value-added features and real content as the project progresses.  Initial data will consist of canned text and mocked information with some real-applications used for testing the installation management.  Second phase will expand to include some initial logical component expansion as well as implementation of real core functionality using the first phase build products.

## Architecture Notes

The primary application should utilize a minimum of Activities and focus primary content areas delivered via Fragments.  The project will include support for orientation changes and will need to appropriate support rotation.  Data, placeholder or real, should be delivered through the ContentProvider and not stored in local in-memory containers.  Events should be communicated via non-exported Broadcasts.  Notification will be needed to communicate to the user regarding background events.  Background services should be utilized to monitor application state and syncrhonized versions with the backend once operational.

## Contributing

This project utilizes a loose git-flow source management flow (http://nvie.com/posts/a-successful-git-branching-model/).  Each new feature and task should receive a dedicated branch (ie. feature/category-list).  Upon completion of the branch's associated task, a pull request should be generated to merge the branch into "develop". At this point, the team shall perform a code review and, if accepted, merge into the main working branch (develop).  Once a milestone has been completed, the "develop" branch will be merged up to "master" and a release tag generated.  Branches should not modify build numbers as this will be incorporated in the release stategy.  Please ensure all referenced content is fully included and committed with a branch before a pull request is issued, missing content will result in an immediate rejection.  Please add notes and any additional non-code information in the associated [Wiki](../../wiki).

## Libraries

Any 3rd party libraries utilized should be referneced in the gradle build system as well as below:

 * com.android.support:appcompat-v7:22.0.0
 
All referenced libraries must comply with a GPLv3, ASL or MIT open-source license or be provided as part of the google ecosystem.  Any library utilized that does not fit this requirement will need to be replaced.  If a library does not have a valid license stipulating it's copyrights, it must provide a public source repository and a private fork should be created to isolate the needed functionality under the scope of our project to protect against post-release license issues.
