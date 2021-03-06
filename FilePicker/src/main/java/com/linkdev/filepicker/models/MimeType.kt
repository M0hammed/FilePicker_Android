/*
 * Copyright (C) 2020 Link Development
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.linkdev.filepicker.models

/**
 * include all available mime types
 * @param mimeTypeName for mime type pass to action
 * @param fileExtension for file extension*/
enum class MimeType(val mimeTypeName: String, val fileExtension: ArrayList<String>) {
    // ============== IMAGES ==============
    JPEG("image/jpeg", arrayListOf("jpg", "jpeg")),
    PNG("image/png", arrayListOf("png")),
    GIF("image/gif", arrayListOf("gif")),
    BMP("image/x-ms-bmp", arrayListOf("bmp")),
    WEBP("image/webp", arrayListOf("webp")),
    ALL_IMAGES("image/*", arrayListOf("jpg", "jpeg", "png", "gif", "bmp", "webp")),

    // ============== VIDEOS ==============
    MPEG("video/mpeg", arrayListOf("mpeg")),
    MP4("video/mp4", arrayListOf("mp4")),
    GPP("video/3gpp", arrayListOf("3gpp")),
    GPP2("video/3gpp2", arrayListOf("3gpp2")),
    AVI("video/avi", arrayListOf("avi")),
    ALL_VIDEOS("video/*", arrayListOf("mpeg", "mp4", "3gpp", "3gpp2", "avi")),

    // ============== TEXT FILES ==============
    TXT("text/plain", arrayListOf("txt", "tex")),
    PDF("application/pdf", arrayListOf("pdf")),
    DOC("application/msword", arrayListOf("doc", "docx")),
    DOCX(
        "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
        arrayListOf("docx")
    ),
    XLS("application/vnd.ms-excel", arrayListOf("xls")),
    XLSX(
        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
        arrayListOf("xlsx")
    ),
    PTT("application/vnd.ms-powerpoint", arrayListOf(".ppt")),
    PTTX(
        "application/vnd.openxmlformats-officedocument.presentationml.presentation",
        arrayListOf(".pptx")
    ),

    // ============== Audio ==============
    MP3("audio/mpeg", arrayListOf("mp3")),
    AUDIO_3GPP("audio/3gpp", arrayListOf("3gp")),
    AUDIO_MP4("audio/mp4", arrayListOf("mp4", "m4a")),
    AUDIO_AMR("audio/amr", arrayListOf("amr")),
    AUDIO_MIDI("audio/midi", arrayListOf("mid")),
    AUDIO_X_MIDI("audio/x-midi", arrayListOf("midi")),
    AUDIO_OGG("application/ogg", arrayListOf("ogg")),
    AUDIO_WAV("audio/wav", arrayListOf("wav")),
    ALL_AUDIO(
        "audio/*",
        arrayListOf("mp3", "3gp", "mp4", "m4a", "amr", "midi", "mid", "ogg", "wav")
    ),


    ALL_FILES("*/*", arrayListOf("*/*"));

    companion object {
        internal fun getArrayOfMimeType(mimeTypeList: ArrayList<MimeType>): Array<String> {
            if (mimeTypeList.isEmpty()) return arrayOf(ALL_FILES.mimeTypeName)
            val mMimeTypeList = ArrayList<String>()
            for (mimeType: MimeType in mimeTypeList) {
                mMimeTypeList.add(mimeType.mimeTypeName)
            }
            return mMimeTypeList.toTypedArray()
        }

        fun toList(): ArrayList<MimeType> {
            return arrayListOf(
                ALL_IMAGES, JPEG, PNG, GIF, BMP, WEBP, ALL_VIDEOS, MPEG,
                MP4, GPP, GPP2, AVI, TXT, PDF, DOC, DOCX, XLS, XLSX, PTT,
                ALL_AUDIO, PTTX, MP3, AUDIO_3GPP, AUDIO_MP4, AUDIO_AMR, AUDIO_MIDI, AUDIO_X_MIDI,
                AUDIO_OGG, AUDIO_WAV
            )
        }

        fun isImage(mimeType: String): Boolean {
            return mimeType == JPEG.mimeTypeName || mimeType == PNG.mimeTypeName || mimeType == GIF.mimeTypeName
                    || mimeType == BMP.mimeTypeName || mimeType == WEBP.mimeTypeName
        }

        fun isVideo(mimeType: String): Boolean {
            return mimeType == MPEG.mimeTypeName || mimeType == MP4.mimeTypeName || mimeType == GPP2.mimeTypeName
                    || mimeType == GPP.mimeTypeName || mimeType == AVI.mimeTypeName
        }
    }
}