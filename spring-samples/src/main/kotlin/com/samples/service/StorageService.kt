package com.samples.service

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

abstract class StorageService

@Component
@Order(2)
class CloudStorageService : StorageService()

@Component
@Order(3)
class DatabaseStorageService : StorageService()


@Component
@Order(1)
class FileSystemStorageService : StorageService()