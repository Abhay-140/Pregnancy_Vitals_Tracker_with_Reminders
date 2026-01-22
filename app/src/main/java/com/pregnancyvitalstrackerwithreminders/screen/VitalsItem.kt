package com.pregnancyvitalstrackerwithreminders.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pregnancyvitalstrackerwithreminders.R
import com.pregnancyvitalstrackerwithreminders.data.VitalsEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun VitalsItem(vitals: VitalsEntity) {

    val dateFormat = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.getDefault())

    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFFEBB9FF))
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
            ) {

                // LEFT COLUMN
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    VitalIconText(
                        icon = R.drawable.heartbeat_img,
                        text = "${vitals.heartRate} bpm"
                    )

                    VitalIconText(
                        icon = R.drawable.weight_img,
                        text = "${vitals.weight} kg"
                    )
                }

                // RIGHT COLUMN
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    VitalIconText(
                        icon = R.drawable.sys_dia_img,
                        text = "${vitals.sysBP}/${vitals.diaBP} mmHg"
                    )

                    VitalIconText(
                        icon = R.drawable.baby_img,
                        text = "${vitals.babyKicks} kicks"
                    )
                }
            }



            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF9C4DBA),
                        shape = RoundedCornerShape(
                            bottomStart = 12.dp,
                            bottomEnd = 12.dp
                        )
                    )
                    .padding(vertical = 6.dp, horizontal = 12.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dateFormat.format(Date(vitals.timestamp)),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

        }
    }
}


@Composable
fun VitalIconText(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = text,
            color = Color(0xFF3F0A71),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

