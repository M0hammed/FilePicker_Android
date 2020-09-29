# **FilePicker**
[![Platform](https://img.shields.io/badge/platform-android-brightgreen.svg)](https://developer.android.com/index.html)
![API](https://img.shields.io/badge/Min--SDK-21-yellowgreen)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
# **What is it?**
FilePicker allows you easily capture image, record video from camera or pick any type of file from document with custom Mime type without creating lots of boilerplate.

# **Setup**

### To Import FilePicker to your project:
1. Open your project in Android Studio
2. Download the library (using Git, or a zip archive to unzip)
3. Go to File > Import Module and import the library as a module
4. Right-click on app in your project view and select "Open Module Settings"
5. Click the "Dependencies" tab and then the '+' button
6. Select "Module Dependency"
7. Select "FilePicker"

### Runtime permissions
This library requires specific runtime permissions. Declare it in your `AndroidMnifest.xml`:
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.CAMERA" />
```
**Note**: for devices running API 23 (Marshmallow) you have to request these permissions in the runtime, before calling `IPickFilesFactory.openCamera()`. It's demonstrated in the sample app.

# **Usage**

Create IPickFileFactory like this:
```kotlin
private var pickFilesFactory: IPickFilesFactory? = null
```
### Capture photo
```kotlin
// folderName is the directory to save captured photo if it is null will save file in default directory.
pickFilesFactory = PickFilesFactory(
               private val fragment: Fragment,
               private val requestCode: Int,
               private val folderName: String? = null
            ).getPickInstance(FactoryFilesType.IMAGE_CAMERA)
            pickFilesFactory?.pickFiles()
```

### Record video
```kotlin
// folderName is the directory to save recorded videos if it is null will save file in default directory.
pickFilesFactory = PickFilesFactory(
               private val fragment: Fragment,
               private val requestCode: Int,
               private val folderName: String? = null
            ).getPickInstance(FactoryFilesType.VIDEO_CAMERA)
            pickFilesFactory?.pickFiles()
```
### pick files from documents
```kotlin
// selectionType is to allow multiple selection or not
// mimeTypeList list of supported files mime types to be picked.
pickFilesFactory = PickFilesFactory(
               private val fragment: Fragment,
               private val requestCode: Int,
               private val selectionType: SelectionTypes = SelectionTypes.SINGLE
            ).getPickInstance(FactoryFilesType.PICK_FILES)
            pickFilesFactory?.pickFiles(mimeTypeList: ArrayList<MimeType> = arrayListOf(MimeType.ALL_FILES))
```
### Getting picked files list
```kotlin
fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        pickFilesFactory?.handleActivityResult(requestCode, resultCode, data, object :
        PickFilesStatusCallback {
        override fun onPickFileCanceled() {
        // pick file process canceled by user (resultCode = RESULT_CANCELED)
        }

        override fun onPickFileError(errorModel: ErrorModel) {
        // some error occurred
        }

        override fun onFilePicked(fileData: ArrayList<FileData>) {
        // files picked successfully 
        }
    })
                
 }
```
# **License**
    Copyright 2020-present Link Development

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 