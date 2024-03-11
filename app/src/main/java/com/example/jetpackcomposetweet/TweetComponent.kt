package com.example.jetpackcomposetweet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TweetComponent() {
Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .height(intrinsicSize = IntrinsicSize.Max)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan)
                    .weight(1f)
            ) {
                Sidebar()
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF171F2A))
                    .weight(4f)
                    .padding(end = 24.dp)
            ) {
                Header()
                Body()
                Footer()
            }
        }
        Divider(
            modifier = Modifier
                .background(Color(0xFFF0F0F0))
                .height(0.5.dp)
        )

}

@Composable
fun Footer() {
    var commentButtonState by remember { mutableStateOf(false) }
    var repostButtonState by remember { mutableStateOf(false) }
    var likeButtonState by remember { mutableStateOf(false) }
    var commentsCounter by remember { mutableIntStateOf(1) }
    var repostsCounter by remember { mutableIntStateOf(1) }
    var likesCounter by remember { mutableIntStateOf(1) }
    Row(
        modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val commentImageButton =
            iconSetter(commentButtonState, R.drawable.ic_chat_filled, R.drawable.ic_chat)
        IconButton(modifier = Modifier.size(24.dp), onClick = {
            commentButtonState = !commentButtonState
            if (commentButtonState) commentsCounter++ else commentsCounter--
        }) {
            val commentButtonColor: Color = when (commentButtonState) {
                true -> Color(0xFF7E8B98)
                false -> Color(0xFF7E8B98)
            }
            Icon(
                painterResource(id = commentImageButton),
                contentDescription = "leave comment",
                tint = commentButtonColor
            )
        }
        Text(
            text = commentsCounter.toString(),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 2.dp),
            color = Color(0xFF7E8B98)
        )
        Spacer(modifier = Modifier.weight(1f))

        val repostImageButton = iconSetter(repostButtonState, R.drawable.ic_rt, R.drawable.ic_rt)
        IconButton(modifier = Modifier.size(24.dp), onClick = {
            repostButtonState = !repostButtonState
            if (repostButtonState) repostsCounter++ else repostsCounter--
        }) {
            val repostButtonColor: Color = when (repostButtonState) {
                true -> Color(0xFF00FF27)
                false -> Color(0xFF7E8B98)
            }
            Icon(
                painterResource(id = repostImageButton),
                contentDescription = "repost",
                tint = repostButtonColor
            )
        }
        Text(
            text = repostsCounter.toString(),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 2.dp),
            color = Color(0xFF7E8B98)
        )
        Spacer(modifier = Modifier.weight(1f))

        val likeImageButton =
            iconSetter(likeButtonState, R.drawable.ic_like_filled, R.drawable.ic_like)
        IconButton(modifier = Modifier.size(24.dp), onClick = {
            likeButtonState = !likeButtonState
            if (likeButtonState) likesCounter++ else likesCounter--
        }) {
            val likesButtonColor: Color = when (likeButtonState) {
                true -> Color(0xFFFF0000)
                else -> Color(0xFF7E8B98)
            }
            Icon(
                painterResource(id = likeImageButton),
                contentDescription = "like",
                tint = likesButtonColor
            )
        }
        Text(
            text = likesCounter.toString(),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 2.dp),
            color = Color(0xFF7E8B98)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun Body() {
    Text(
        text = "Lorem ipsum dolor sit amet consectetur adipiscing elit morbi luctus accumsan " +
                "hac odio, habitasse venenatis vitae tincidunt ultrices tortor urna himenaeos " +
                "auctor in.",
        lineHeight = 18.sp,
        color = Color(0xFFFCFFFF)
    )
    Spacer(modifier = Modifier.padding(top = 12.dp))
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "body image",
        modifier = Modifier
            .clip(
                RoundedCornerShape(24.dp)
            )
            .aspectRatio(16f / 12f),
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    Row(modifier = Modifier.fillMaxWidth()) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            Text(
                text = "Aris",
                modifier = Modifier.padding(end = 8.dp).align(Alignment.Top),
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFCFFFF),
            )
            Text(
                text = "@AristiDevs",
                modifier = Modifier.padding(end = 8.dp),
                color = Color.Gray
            )
            Text(text = "4h", color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(21.dp)) {
                Icon(
                    painterResource(id = R.drawable.ic_dots),
                    contentDescription = "dots",
                    tint = Color(0xFFF0F0F0)
                )
            }
        }
    }
}

@Composable
fun Sidebar() {
    Box(
        modifier = Modifier
            .background(Color(0xFF171F2A))
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "body image",
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .clip(CircleShape)
        )

    }
}

fun iconSetter(
    imageState: Boolean,
    @DrawableRes filledIcon: Int,
    @DrawableRes unfilledIcon: Int
): Int {
    return if (imageState) filledIcon else unfilledIcon
}