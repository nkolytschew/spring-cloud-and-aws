package com.github.nkolytschew2.aws.core.resource.mvc.model

import java.util.*

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.0.0-SNAPSHOT
 */
class ResourceModel(val id: String = UUID.randomUUID().toString(),
                    val content: String)