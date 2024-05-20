package com.marco.ensominaearser.repository

import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class ChatRepository {
    private val mFireStore = FirebaseFirestore.getInstance()
    fun listenConversations(
        collectionName: String,
        senderIdKey: String,
        patientIdKey: String,
        receiverIdKey: String,
        eventListener: EventListener<QuerySnapshot>
    ) {
        mFireStore.collection(collectionName)
            .whereEqualTo(
                senderIdKey,
                patientIdKey
            )
            .addSnapshotListener(eventListener)

        mFireStore.collection(collectionName)
            .whereEqualTo(
                receiverIdKey,
                patientIdKey
            )
            .addSnapshotListener(eventListener)
    }
}