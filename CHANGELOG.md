# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2024.12.04
### Added
- **Testing Suite**: Implemented a comprehensive set of tests for the PlantTracker component, ensuring all methods function as expected.
- **Lib JAR Files**: Added necessary library JAR files to the project for handling dependencies.
- **Reflection of Project**: Completed a reflective analysis of the project to evaluate learning outcomes and challenges encountered during development.

### Changed
- **Project Structure**: Refined project organization, improving file layering for better maintainability and clarity.
- **Core Methods**: Adjusted the implementation of certain methods to improve testability and functionality.

## 2024.11.15
### Added
- **`addPlant`**: Allows the user to add a new plant to the tracker, ensuring no duplicates are added.
- **`removePlant`**: Removes a plant from the tracker by name.
- **`getRandomPlant`**: Retrieves a random plant from the tracker and displays its details.
- **`listAllPlants`**: Lists all plant names currently in the tracker.
- **`listPlantsThatNeedWater`**: Lists all plants that need water (i.e., have not been watered in the last 7 days).
- **`waterPlant`**: Waters a specific plant, updating its last watered date.
- **`showCareInstructions`**: Displays the care instructions for a specific plant.

### Changed
- **`PlantTracker` Class**: Refactored core methods to ensure they interact with a `Map<String, Plant>` data structure for efficient plant management.
- **`needsWater` Method in `Plant`**: Added logic to check if a plant requires watering based on the last watered date.

## 2024.10.27

### Added

- Designed abstract class `ComponentSecondary` for the portfolio project, implementing all secondary methods as specified in the enhanced interface.
- Included `toString()` and `equals()` methods to the abstract class, ensuring adherence to design-by-contract principles.
- Implemented secondary methods using kernel methods only, as required by the assignment guidelines.

### Updated

- Refined method implementations to check preconditions and align with kernel method contracts.
- Enhanced code organization and documentation for clarity and maintainability.

## 2024.09.29

### Added

- Designed a proof of concept for **PlantTracker** component.

### Updated

- Changed design to include improved user interface for adding, watering, and viewing plant care instructions.


## 2024.09.05

### Added

- Designed a Dinner Party Planner component
- Designed a plant care reminder & trackercomponent
- Designed a vision board (pinterest-like) component

## [Unreleased]

## [2024.08.07]

### Added

- Added `/bin` to `.gitignore`, so binaries are no longer committed
- Added the TODO tree extensions to `extensions.json`
- Added the `todo-tree.general.showActivityBarBadge` setting to `settings.json`
- Added the `todo-tree.tree.showCountsInTree` setting to `settings.json`
- Added the VSCode PDF extension to `extensions.json`
- Added `java.debug.settings.vmArgs` setting to enable assertions (i.e., `-ea`)
- Added information about making branches to all parts of the project
- Added information about how to update the CHANGELOG to every part of the
  project
- Added information about how to make a pull request to every part of the
  project

### Changed

- Updated `settings.json` to format document on save using `editor.formatOnSave`
  setting
- Updated `settings.json` to exclude certain files from markdown to PDF
  generation using `markdown-pdf.convertOnSaveExclude` setting
- Updated `settings.json` to use latest `java.cleanup.actions` setting
- Updated `settings.json` to automatically choose line endings using `files.eol`
  setting
- Updated `settings.json` to organize imports automatically on save using the
  `editor.codeActionsOnSave` and `source.organizeImports` settings
- Changed the component brainstorming assignment to ask a few clarifying
  questions
- Changed the component brainstorming example from `Point3D` to `NaturalNumber`
  to avoid the getter/setter trend
- Updated assignment feedback sections to include a link to a survey that
  I'll actually review
- Updated README to include step about using template repo
- Updated part 3 rubric to include a hierarchy diagram
- Updated part 6 rubric to account for overall polish

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07
